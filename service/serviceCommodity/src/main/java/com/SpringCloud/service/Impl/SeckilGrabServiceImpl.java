package com.SpringCloud.service.Impl;

import com.SpringCloud.entity.Collect;
import com.SpringCloud.entity.Commodity;
import com.SpringCloud.entity.Person;
import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.Order;
import com.SpringCloud.mapper.*;
import com.SpringCloud.service.CollectService;
import com.SpringCloud.service.CommodityService;
import com.SpringCloud.service.SeckilGrabService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
    public class SeckilGrabServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements SeckilGrabService {
   @Override
        public String gradOrder(int goodsId, int userId){
            try{
                System.out.println("用户"+userId+"执行请求");
                boolean b=grad(goodsId,userId);
                if(b){
                    System.out.println("用户"+userId+"抢单成功");
                }else{
                    System.out.println("用户"+userId+"抢单成功");
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
    }
