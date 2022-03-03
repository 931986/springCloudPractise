package com.SpringCloud.Controller;


import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.GoodsInfo;
import com.SpringCloud.entity.form.GoodsVo;
import com.SpringCloud.entity.form.Result;
import com.SpringCloud.service.Impl.SeckillService;
import com.SpringCloud.service.Impl.lock.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")

@RequestMapping("/api/Goods")
public class GoodsController {

//    商品信息展示
//    对秒杀后的数据进行修改原始数据库修改
@Autowired
private GoodsService goodsService;
    @Autowired
    private SeckillService seckillService;

    @PostMapping("/GoodsDetail/{goodsId}")
    public GoodsVo list(@PathVariable("goodsId") long goodsId) {


//        秒杀库  对应 goodseckillcenter
       Goods goods=goodsService.ListGoodSeckill(goodsId);
        System.out.println(goods);
        //        信息库  对应 goodscenter
        GoodsInfo goodsInfo=goodsService.getGoodsInfoByGoodsId(goodsId);
        System.out.println(goodsInfo);
        GoodsVo goodsVo=new GoodsVo();
        BeanUtils.copyProperties(goodsInfo,goodsVo);
        BeanUtils.copyProperties(goods,goodsVo);
        System.out.println(goodsVo);
        return goodsVo;

    }



    }
