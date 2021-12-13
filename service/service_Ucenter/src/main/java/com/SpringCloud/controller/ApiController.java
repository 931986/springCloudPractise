package com.SpringCloud.controller;


import com.SpringCloud.base.R;
import com.SpringCloud.entity.RegisterInfo;
import com.SpringCloud.service.UserService;
import com.SpringCloud.util.UcenterProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.UUID;

@RestController
        @RequestMapping("/api/Ucenter/wx")
@Slf4j
public class ApiController {
    @Autowired
    private UserService userService;
    @Autowired
    private UcenterProperties ucenterProperties;


    @PostMapping("/login")


    public String Register(HttpSession httpSession){
        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        //处理回调url
        String redirecturi = "";
        try{
            redirecturi= URLEncoder.encode(ucenterProperties.getRedirectUri(),"utf-8");

        }catch (Exception e){

            e.printStackTrace();
//            自己写个异常处理的excetion
        }
        String state= UUID.randomUUID().toString();
        log.info("state:"+state);
        httpSession.setAttribute("open_state",state);
      String qrcodeUrl=String.format(
              baseUrl,
              ucenterProperties.getAppId(),
              redirecturi,
              state
      );
        return "redirect:"+qrcodeUrl;

    }
}
