package com.SpringCloud.Controller;


import com.SpringCloud.entity.form.*;

import com.SpringCloud.rabbitmq.MQSender;
import com.SpringCloud.rabbitmq.SeckillMessage;
import com.SpringCloud.redis.redis.GoodsKey;
import com.SpringCloud.redis.redis.RedisService;
import com.SpringCloud.service.Impl.OrderService;
import com.SpringCloud.service.Impl.lock.GoodsService;
//import com.SpringCloud.service.Impl.lock.RedisLockService;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")

@RequestMapping("/api/Goods")
public class MiaoshaController implements InitializingBean {
    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

//    @Autowired
//    SeckillService seckillService;
//@Autowired
//private RedisLockService redisLockService;

    @Autowired
    RedisService redisService;

//    @Autowired
//    MQSender sender;

    //基于令牌桶算法的限流实现类
    RateLimiter rateLimiter = RateLimiter.create(10);

    //做标记，判断该商品是否被处理过了
    private HashMap<Long, Boolean> localOverMap = new HashMap<Long, Boolean>();

    /**
     * GET POST
     * 1、GET幂等,服务端获取数据，无论调用多少次结果都一样
     * 2、POST，向服务端提交数据，不是幂等
     * <p>
     * 将同步下单改为异步下单
     *
//     * @param model
//     * @param user
//     * @param goodsId
//     * @return
     */
    @Autowired
    MQSender sender;


    @RequestMapping(value = "/seckill/{goodsId}", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> list( @PathVariable("goodsId") long goodsId) {
        Random r=new Random();
     long  userId=r.nextInt(30);
//        加减库存，可不可以用Redis中List数据类型存库存呢，多少个元素就是多少个库存；

//        用户取消订单 回库过程
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            return  Result.error(CodeMsg.ACCESS_LIMIT_REACHED);
        }

//        if (user == null) {
//            return Result.error(CodeMsg.SESSION_ERROR);
//        }
//        model.addAttribute("user", user);
        //内存标记，减少redis访问
//        boolean over = localOverMap.get(goodsId);
//        if (over) {
//            return Result.error(CodeMsg.SECKILL_OVER);
//        }
        //预减库存

//         long stock=redisLockService.DecrLock(goodsId);
        long stock = redisService.decr(GoodsKey.getGoodsStock, "" + goodsId);//10
        if (stock < 0) {
            afterPropertiesSet();
            long stock2 = redisService.decr(GoodsKey.getGoodsStock, "" + goodsId);//10
//            long stock2=redisLockService.DecrLock(goodsId);;
            if(stock2 < 0){
                localOverMap.put(goodsId, true);
                return Result.error(CodeMsg.SECKILL_OVER);
            }
        }
        //判断重复秒杀
        OrderInfo order = orderService.getOrderByUserIdGoodsId(userId, goodsId);
        if (order != null) {
            return Result.error(CodeMsg.REPEATE_SECKILL);
        }
        //入队
        SeckillMessage message = new SeckillMessage();
        message.setId(userId);
        message.setGoodsId(goodsId);
        sender.sendSeckillMessage(message);
        return Result.success(0);//排队中
    }

    /**
     * 系统初始化,将商品信息加载到redis和本地内存
     */

     @Override
    public void afterPropertiesSet() {


        List<GoodsVo> goodsVoList = goodsService.listGoodsVo();
        if (goodsVoList == null) {
            return;
        }
        for (Goods goods : goodsVoList) {
            redisService.set(GoodsKey.getGoodsStock, "" + goods.getId(), goods.getNum());
//            operations.set("GoodsKeys:gs"+goods.getId(),String.valueOf(goods.getNum()));
//            redisLockService.setLock(goods.getId(),goods.getNum());
            //初始化商品都是没有处理过的
            localOverMap.put(goods.getId(), false);
        }
    }

    /**
     * orderId：成功
     * -1：秒杀失败
     * 0： 排队中
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseBody
    public Result<Integer>  seckillResult(
                                      @RequestParam("goodsId") long goodsId) {
//        model.addAttribute("user", user);
//        if (user == null) {
//            return Result.error(CodeMsg.SESSION_ERROR);//        }
//        long orderId = seckillSe00ice.getSeckillResult(user.getId(), goodsId);
        return Result.success(1);
    }
}