package com.SpringCloud.service;

import com.SpringCloud.entity.Commodity;
import com.SpringCloud.entity.Person;
import com.SpringCloud.entity.form.Goods;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface SeckilGrabService  extends IService<Goods>{
//   已经弃用
   public String gradOrder(int goodsId, int userId);
//   public List<Goods> findAll();



}
