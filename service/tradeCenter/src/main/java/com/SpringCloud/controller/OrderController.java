package com.SpringCloud.controller;

import com.SpringCloud.base.R;
import com.SpringCloud.entity.Order;
import com.SpringCloud.service.OrderService;
import com.SpringCloud.util.JwtInfo;
import com.SpringCloud.util.JwtUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@RestController
        @Slf4j
        @RequestMapping("/api/trade")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order/create/{commodityId}")
    public R SaveOrder(@PathVariable("commodityId") String commodityId, HttpServletRequest request){
        JwtInfo jwtInfo = JwtUtils.getMemberIdByJwtToken(request);
        System.out.println(jwtInfo);
        System.out.println("toHere");
//        Exception逻辑
//        if (jwtInfo == null) {
//            throw new CollegeException(ResultCodeEnum.LOGIN_AUTH);
//        }
//        jwtInfo.getId()
        String memId="1";
     String orderid = orderService.saveOrder(commodityId,memId );

        return R.ok().data("200",orderid);
    }
    @PostMapping("/order/Get/{orderId}")
    public R GetOrderById(@PathVariable("orderId") String id){
        return R.ok().data("200",orderService.getById(id));
    }
    @PostMapping("/order/GetName/{orderName}")
    public R GetOrderByName(@PathVariable("orderName") String name){
        return R.ok().data("200",orderService.getByName(name));
    }

}
