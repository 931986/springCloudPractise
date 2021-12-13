package com.SpringCloud.service;

import com.SpringCloud.entity.Commodity;
import com.SpringCloud.entity.CommodityDto;
import com.SpringCloud.entity.form.CommodityBaseForm;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

public interface CommodityService  extends IService<Commodity>{
//         public  String saveCommodityBaseInfo(CommodityBaseForm commodityBaseForm){
     public  CommodityBaseForm GetCommodityById(int id);
     public  String saveCommodityBaseInfo(CommodityBaseForm commodityBaseForm);
     public CommodityDto GetCommodityDtoById(String commodityId);

}
