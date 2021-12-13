package com.SpringCloud.controller;


import com.SpringCloud.base.R;
import com.SpringCloud.entity.RegisterInfo;
import com.SpringCloud.entity.UserInfo;
import com.SpringCloud.entity.loginInfo;
import com.SpringCloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")


        @RequestMapping("/api/Ucenter/")
public class ApiUserController {

    @Resource
    private UserService userService;
    @PostMapping("register")
    public R Register(@Validated @RequestBody RegisterInfo registerInfo){

        userService.register(registerInfo);
        return R.ok();

    }
    @PostMapping("login")
    public R login(@Validated @RequestBody loginInfo user){

       String token=userService.login(user);
        return R.ok().data("userToken",token);

    }



}
