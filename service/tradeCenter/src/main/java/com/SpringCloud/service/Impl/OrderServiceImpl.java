package com.SpringCloud.service.Impl;

import com.SpringCloud.Dto.CommodityDto;
import com.SpringCloud.base.R;
import com.SpringCloud.entity.Order;
import com.SpringCloud.feign.CommodityService;
import com.SpringCloud.mapper.OrderMapper;
import com.SpringCloud.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService {

    @Autowired
    private CommodityService commodityService;
   @Override

    public String saveOrder( String memberId,String commodityId){

        QueryWrapper<Order> queryWrapper=new QueryWrapper();
//        这个方法类似于hash里面的查询
//        queryWrapper.eq("order_id",orderId);
       queryWrapper.eq("id",commodityId);
        queryWrapper.eq("buyer_id",memberId);
       Order orderExist=baseMapper.selectOne(queryWrapper);
//       if(orderExist!=null){
//           return orderExist.getOrderId();
//       }
       CommodityDto commodityDto=commodityService.GetCommodityDtoById(commodityId);
System.out.println(commodityDto);
       Order order=new  Order();
//       order.setOrderId(orderId);
       order.setBuyerId(memberId);
       order.setCommodityCover(commodityDto.getCover());
       order.setCommodityId(commodityDto.getId());
       order.setCommodityName(commodityDto.getName());
       order.setSellerName(commodityDto.getSellerName());

        order.setPayStatus("0");//未支付
        order.setPayChoice("1");//微信支付

        baseMapper.insert(order);

       return order.getOrderId();

    }
  @Override
    public Order getByName(String name){
      QueryWrapper<Order> queryWrapper=new QueryWrapper();
      queryWrapper.eq("commodity_name",name);
      Order orderExist=baseMapper.selectOne(queryWrapper);
      return orderExist;


    }

}
