package com.SpringCloud.Controller;

import com.SpringCloud.base.R;
import com.SpringCloud.entity.form.CommodityBaseForm;
import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.redis.redis.GoodsKey;
import com.SpringCloud.redis.redis.RedisService;
import com.SpringCloud.service.CommodityService;
import com.SpringCloud.service.SeckilGrabService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
        @Slf4j
@ComponentScan(basePackages = "com.SpringCloud.mapper")

        @RequestMapping("/api/commodity")
public class CommodityController {

    @Resource
    private CommodityService commodityService;



    @PostMapping("saveCommodity")
       public R SaveCommodityBaseInfo(@ApiParam(value="商品基本信息",required = true)
               @RequestBody CommodityBaseForm commodityBaseForm){
             System.out.println(commodityBaseForm);
               String coureId=commodityService.saveCommodityBaseInfo(commodityBaseForm);
                return R.ok().data("couresId",coureId).message("200");
       }
        @GetMapping("/get/{Commodity_Id}")
        public R GetCommodityBaseInfo(@ApiParam(value="商品id",required = true)
                                      @PathVariable("Commodity_Id")  String id
                                       ){
             System.out.println(id);
                CommodityBaseForm commodityBaseForm=commodityService.GetCommodityById(Integer.parseInt(id));
                if(commodityBaseForm==null){
                    return R.ok().message("不存在该商品");
                }
                return R.ok().data("CommodityBaseForm",commodityBaseForm).message("200");
        }
    //        这一步是进行压测和加锁针对高并发情况下的
//    @Resource
//    private SeckilGrabService grabService;
//    @PostMapping("/list")
//    public String findGoodsList(Model model) {
//        List<Goods> list =grabService.findAll();
//        model.addAttribute("list", list);
//        return "page/seckill";
//    }



//    @Qualifier("seckilJVMLockService")

//@PostMapping("/grab/do/{goodsId}")
//
//    public String grabMysql(@PathVariable("goodsId") int goodsId,int userId){
////          grabService.findAll();
//    Random r=new Random();
//    userId=userId+r.nextInt(30);
//        System.out.println("goodId:"+goodsId);
//             System.out.println(grabService.gradOrder(goodsId,userId));
//             return "";
//
//    }







}
