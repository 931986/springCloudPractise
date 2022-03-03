package com.SpringCloud.service.Impl;

import com.SpringCloud.entity.form.GoodsVo;
import com.SpringCloud.entity.form.OrderInfo;
import com.SpringCloud.entity.form.User;
import com.SpringCloud.mapper.OrderMapper;
import com.SpringCloud.redis.redis.OrderKey;
import com.SpringCloud.redis.redis.RedisService;
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


    public OrderInfo getOrderByUserIdGoodsId(long userId, long goodsId) {

        return redisService.get(OrderKey.getSeckillOrderByUidGid, "" + userId + "_" + goodsId, OrderInfo.class);

    }
}
