package com.SpringCloud.service.Impl;

import com.SpringCloud.base.BaseException;
import com.SpringCloud.base.ResultCodeEnum;
import com.SpringCloud.entity.RegisterInfo;
import com.SpringCloud.entity.Response_info;
import com.SpringCloud.entity.UserInfo;
import com.SpringCloud.entity.loginInfo;
import com.SpringCloud.mapper.UserMapper;
import com.SpringCloud.service.UserService;
import com.SpringCloud.util.JwtInfo;
import com.SpringCloud.util.JwtUtils;
import com.SpringCloud.util.MD5;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserInfo>  implements UserService {
   @Resource
   private  UserMapper userMapper;

@Override
   public void register(RegisterInfo registerInfo){

//   检查是否满足注册条件
//   name code emial pass phone
   String name=registerInfo.getName();
   String code=registerInfo.getCode();
   String email=registerInfo.getEmail();
   String pass=registerInfo.getPass();
   String phone=registerInfo.getPhone();


   UserInfo userInfo=new UserInfo();
   BeanUtils.copyProperties(registerInfo,userInfo);
   userInfo.setIs_disabled(false);
//   设置默认头像
   baseMapper.insert(userInfo);

}
    @Override
   public String login(loginInfo user)  {

   String userAccount=user.getUserInfo();
   System.out.println("userAccount"+userAccount);
   String pass=user.getPass();
      //   判定它是电话号还是邮箱还是用户名
QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<>();
queryWrapper.lambda().eq(UserInfo::getAccount,userAccount).or().eq(UserInfo::getPhone,userAccount)
        .or().eq(UserInfo::getEmail,userAccount);
UserInfo user_info=baseMapper.selectOne(queryWrapper);
       System.out.println("user_info:"+user_info);

// //使用邮箱或者手机号登录
//        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
//        queryWrapper.lambda().eq(Member::getMobile, userInfo).or().eq(Member::getEmail, userInfo);
//        System.out.println(userInfo);
//        Member member = baseMapper.selectOne(queryWrapper);

if(user_info==null){
    throw new BaseException(ResultCodeEnum.LOGIN_ERROR);


}
       if (!MD5.encrypt(pass).equals(user_info.getPass())) {
//           return null;

           throw new BaseException(ResultCodeEnum.LOGIN_ERROR);
       }


      Response_info response_info=new Response_info();
  response_info.setAvatar(user_info.getAvatar());
      response_info.setName(user_info.getName());
      response_info.setDes(user_info.getDes());
      response_info.setId(user_info.getId());
      JwtInfo jwtInfo=new JwtInfo();
      BeanUtils.copyProperties(response_info,jwtInfo);
      String jwtToken = JwtUtils.getJwtToken(jwtInfo, 1800);



      return jwtToken;

   }
   }




