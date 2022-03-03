package com.SpringCloud.service.Impl;

import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.GoodsVo;
import com.SpringCloud.entity.form.OrderInfo;
import com.SpringCloud.entity.form.User;
import com.SpringCloud.mapper.GoodsMapper;
import com.SpringCloud.mapper.OrderMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeckillService {


    //保证这三个操作，减库存 下订单 写入秒杀订单是一个事物
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void initializeRedis(long gid) {
       GoodsVo ps = goodsMapper.selectByGoodsId(gid);
        // 删掉以前重复的活动任务
        stringRedisTemplate.delete("seckill:count:" + ps.getGoodsId());
//        stringRedisTemplate.delete("seckill:users" + ps.getGoodsId());
        stringRedisTemplate.delete("seckill:value:" + gid + "-num");
        // 有几件库存商品，则初始化几个list对象
//        for (int i = 0; i < ps.getPsCount(); i++) {
            stringRedisTemplate.opsForList().rightPush("seckill:count:" + ps.getGoodsId(),ps.getNum()+ "");
//        }
    }

    @Transactional
    public void seckill(long goodsId, long userId){
        GoodsVo goods=goodsMapper.selectByGoodsId(goodsId);
        //减库存



        if (goods.getNum()>0){
            //下订单 写入秒杀订单
            goodsMapper.reduceGoods(goodsId);
            System.out.println("执行数据库减少库存");
            User user=new User();
            user.setId((int)userId);
            createOrder(user, goods);
        }else {
//            setGoodsOver((int)goods.getGoodsId());
            return ;
        }
        return;
    }
    @Transactional
    public OrderInfo createOrder(User user, GoodsVo goods){
        OrderInfo order=new OrderInfo();
        order.setDescription(String.valueOf(goods.getGoodsPrice()));
        order.setStatus(1);
        order.setUserId(user.getId());
        order.setGoodsName(goods.getGoodsName());

        order.setDescription(goods.getGoodsDetail());
        order.setGoodsPrice(goods.getSeckillPrice());
        System.out.println("order产生");
        orderMapper.insert(order);


        return order;
    }

}
