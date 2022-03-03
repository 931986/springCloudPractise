package com.SpringCloud.controller;


import com.SpringCloud.base.R;
import com.SpringCloud.entity.RegisterInfo;
import com.SpringCloud.entity.Result.Result;
import com.SpringCloud.entity.Result.ResultFactory;
import com.SpringCloud.entity.loginInfo;
import com.SpringCloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")


        @RequestMapping("/api/Ucenter/")
public class ApiUserController {

    @Resource
    private UserService userService;
//    @CrossOrigin(allowCredentials = "true")
    @PostMapping("register")
    public R Register(@Validated @RequestBody RegisterInfo registerInfo){

        userService.register(registerInfo);
        return R.ok();

    }
//    @CrossOrigin 已经写过全局跨域了，所以这里后端就不用写了
    @PostMapping("login")
    public R login(@Validated @RequestBody loginInfo user){

       String token=userService.login(user);
       System.out.println(token);
        return R.ok().data("userToken",token);

    }
//    @CrossOrigin
    @PostMapping(value = "loginShiro")
    @ResponseBody
    public Result login(@RequestBody loginInfo user_get, HttpSession session) {
        System.out.println(user_get);

        String userName = user_get.getUserInfo();
        Subject subject= SecurityUtils.getSubject();

        userName = HtmlUtils.htmlEscape(userName);
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(userName,user_get.getPass());
        System.out.println("这一步");
        usernamePasswordToken.setRememberMe(true);


        try{
            subject.login(usernamePasswordToken);
            System.out.println("login success");
            return ResultFactory.buildSuccessResult(userName);
        }catch (AuthenticationException e){
            String message="login error";
            return ResultFactory.buildFailResult(message);

        }


    }



}
