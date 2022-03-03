package com.SpringCloud.service;

import com.SpringCloud.entity.RegisterInfo;
import com.SpringCloud.entity.UserInfo;
import com.SpringCloud.entity.loginInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<UserInfo> {
   public   void register(RegisterInfo registerInfo);
   public String login(loginInfo user) ;
}
