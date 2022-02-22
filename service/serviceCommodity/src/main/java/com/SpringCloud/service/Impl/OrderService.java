package com.SpringCloud.service.Impl;

import com.SpringCloud.entity.MiaoshaOrder;

import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.Order;
import com.SpringCloud.entity.form.User;
import com.SpringCloud.mapper.OrderMapper;
import com.SpringCloud.redis.redis.OrderKey;
import com.SpringCloud.redis.redis.RedisService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisService redisService;

    @Transactional
    public Order createOrder(User user, Goods goods){
        Order order=new Order();
        order.setDescription(String.valueOf(goods.getSeckill_price()));
        order.setStatus(1);
        order.setUserId(user.getId());
        System.out.println("order产生");
        orderMapper.insert(order);


        return order;
    }


    public Order getOrderByUserIdGoodsId(long userId, long goodsId) {

        return redisService.get(OrderKey.getSeckillOrderByUidGid, "" + userId + "_" + goodsId, Order.class);

    }
}
