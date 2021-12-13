package com.SpringCloud.service;

import com.SpringCloud.base.R;
import com.SpringCloud.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.catalina.authenticator.SavedRequest;

public interface OrderService extends IService<Order> {


    public String saveOrder(String memberId,String commodityId);

    public Order getByName(String name);
}
