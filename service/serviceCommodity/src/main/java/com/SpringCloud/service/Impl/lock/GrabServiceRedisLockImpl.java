package com.SpringCloud.service.Impl.lock;

import com.SpringCloud.entity.MiaoshaOrder;
import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.Order;
import com.SpringCloud.mapper.GoodsMapper;
import com.SpringCloud.mapper.OrderMapper;

import com.SpringCloud.redis.redis.GoodsKey;
import com.SpringCloud.redis.redis.RedisService;
import com.SpringCloud.service.Impl.OrderService;
import com.SpringCloud.service.SeckilGrabService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class GrabServiceRedisLockImpl extends ServiceImpl<GoodsMapper, Goods> implements SeckilGrabService {

    @Autowired
    private RedisTemplate redisTemplate;
     @Autowired
     private RedisService redisService;
      @Autowired
      private OrderService orderService;
    private String key="goods";

//    public List<Goods> findAll() {
//        List<Goods> seckillList = redisTemplate.boundHashOps("goods").values();
//        if (seckillList == null || seckillList.size() == 0){
//            //说明缓存中没有秒杀列表数据
//            //查询数据库中秒杀列表数据，并将列表数据循环放入redis缓存中
//            seckillList = goodsMapper.findAll();
//            for (Goods goods : seckillList){
//                //将秒杀列表数据依次放入redis缓存中，key:秒杀表的ID值；value:秒杀商品数据
//                redisTemplate.boundHashOps(key).put(goods.getId(), goods);
////                logger.info("findAll -> 从数据库中读取放入缓存中");
//            }
//        }else{
////            logger.info("findAll -> 从缓存中读取");
//        }
//        return seckillList;
//    }

    @Override
    public String gradOrder(int goodsId, int userId){
        try{
            System.out.println("用户"+userId+"执行请求");
            boolean b=gradByRedis(goodsId,userId);
            if(b){
                System.out.println("成功用户"+userId+"抢单成功");
            }else{
                System.out.println("失败用户"+userId+"抢单失败");
            }
        }finally {


        }
        return "???";
    }
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrderMapper orderMapper;
    public boolean grad(int goodsId, int userId) {
//        会出现超卖
        Goods goods = goodsMapper.selectById(goodsId);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int num = goods.getNum();
        int id=Integer.parseInt(goods.getId());
        if (num > 0) {

            goodsMapper.reduceGoods(id);

            Order order = new Order();
            order.setDescription("用户" + userId + "拿到了小钱钱");
            order.setStatus(1);
            order.setUserId(userId);
            orderMapper.insert(order);

            return true;

        }
        return false;

    }



    @Transactional
    public boolean gradByRedis(int goodsId, int userId) {
//            redis
        //--在sql加上判断防止数据变为负数
//--数据库加唯一索引防止用户重复购买
//--redis预减库存减少数据库访问　内存标记减少redis访问　请求先入队列缓冲，异步下单，增强用户体验
        //是否已经秒杀到


        Goods goods= (Goods) redisTemplate.boundHashOps(key).get(goodsId);
//        先看能不能从redis获取到商品数据>0
//
      if(goods==null) {
//          缓存当中 从数据库当中读取
          goods=goodsMapper.selectById(goodsId);
           redisTemplate.boundHashOps(key).put(goods.getId(),goods);

      }

//        MiaoshaOrder order = orderService.getMiaoshaOrderByUserIdGoodsId(userId, goodsId);
//        if (order != null) {
//
//
//        }

//        boolean over = localOverMap.get(goodsId);
//        if (over) {
////            result.withError(MIAO_SHA_OVER.getCode(), MIAO_SHA_OVER.getMessage());
////            return result;
//            return false;
//        }
        //预见库存
//        Long stock = redisService.decr(GoodsKey.getMiaoshaGoodsStock, "" + goodsId);
//        if (stock < 0) {
//            localOverMap.put(goodsId, true);
////            result.withError(MIAO_SHA_OVER.getCode(), MIAO_SHA_OVER.getMessage());
//            return  false;
//        }
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
  try {
      int num = goods.getNum();
      int id=Integer.parseInt(goods.getId());
      if (num > 0) {

          goodsMapper.reduceGoods(id);

          Order order = new Order();
          order.setDescription("用户" + userId + "拿到了小钱钱");
          order.setStatus(1);
          order.setUserId(userId);
          orderMapper.insert(order);
        Goods goods1= (Goods) redisTemplate.boundHashOps(key).get(goodsId);
          goods1.setNum(goods1.getNum() - 1);
          redisTemplate.boundHashOps(key).put(goodsId,goods1);


      }
  }catch (Exception e){
      e.printStackTrace();
  }finally {
      return true;

  }


    }

    public void afterPropertiesSet() {
        List<Goods> goodsVoList = goodsMapper.listGoodsVo();
        if (goodsVoList == null) {
            return;
        }
        for (Goods goods : goodsVoList) {
            redisService.set(GoodsKey.getGoodsStock, "" + goods.getId(), goods.getNum());
            //初始化商品都是没有处理过的

        }
    }
}


