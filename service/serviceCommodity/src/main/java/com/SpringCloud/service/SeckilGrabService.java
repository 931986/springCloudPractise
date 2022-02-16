package com.SpringCloud.service;

import com.SpringCloud.entity.Commodity;
import com.SpringCloud.entity.Person;
import com.SpringCloud.entity.form.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

public interface SeckilGrabService  extends IService<Goods>{
   public String gradOrder(int goodsId, int userId);



}
