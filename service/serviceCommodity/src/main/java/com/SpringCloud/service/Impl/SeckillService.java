package com.SpringCloud.service.Impl;

import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.Order;
import com.SpringCloud.entity.form.User;
import com.SpringCloud.redis.redis.RedisService;
import com.SpringCloud.redis.redis.SeckillKey;
import com.SpringCloud.service.Impl.lock.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeckillService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private GoodsService goodsService;
    //保证这三个操作，减库存 下订单 写入秒杀订单是一个事物
    @Autowired
    private  OrderService orderService;
    @Transactional
    public Order seckill(User user, Goods goods){
        //减库存
        boolean success = goodsService.reduceStock(goods);
        System.out.println("执行数据库减少库存");
        if (success){
            //下订单 写入秒杀订单
            return orderService.createOrder(user, goods);
        }else {
            setGoodsOver(Integer.parseInt(goods.getId()));
            return  null;
        }
    }
    private void setGoodsOver(int goodsId) {
        redisService.set(SeckillKey.isGoodsOver, ""+goodsId, true);
    }

}
