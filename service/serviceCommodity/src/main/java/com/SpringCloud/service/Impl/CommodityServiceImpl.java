package com.SpringCloud.service.Impl;

import com.SpringCloud.entity.Commodity;
import com.SpringCloud.entity.CommodityDto;
import com.SpringCloud.entity.form.CommodityBaseForm;
import com.SpringCloud.mapper.CommodityMapper;
import com.SpringCloud.service.CommodityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;
//import org.springframework.stereotype.Service;

@Service


public class CommodityServiceImpl extends ServiceImpl<CommodityMapper,Commodity> implements CommodityService {

//public class CommodityServiceImpl extends {

    @Override
    public  String saveCommodityBaseInfo(CommodityBaseForm commodityBaseForm){
        Commodity commodity=new Commodity();


        BeanUtils.copyProperties(commodityBaseForm,commodity);
        commodity.setId(commodityBaseForm.getId());
        System.out.println("commodity: "+commodity);
        commodity.setCommodityStatus(commodity.COMMODITY_DRAFT);
//        commodity.setId("12");
        baseMapper.insert(commodity);
        return  commodity.getId();


    }

    @Override
    public CommodityBaseForm GetCommodityById(int id) {

        Commodity commodity=baseMapper.selectById(id);
        if(commodity==null){
            return null;
        }
        CommodityBaseForm commodityBaseForm=new CommodityBaseForm();
        BeanUtils.copyProperties(commodity,commodityBaseForm);

        return  commodityBaseForm;
    }
    @Override
    public CommodityDto GetCommodityDtoById(String commodityId){

        Commodity commodity=baseMapper.selectById(commodityId);

    CommodityDto commodityDto=new CommodityDto();
   BeanUtils.copyProperties(commodity,commodityDto);
   return  commodityDto;
    }
    @Override
    public Commodity GetCommodityByCommodityId(String commodityId){

          QueryWrapper<Commodity> queryWrapper=new QueryWrapper();
          queryWrapper.eq("commodity_id",commodityId);
        Commodity commodity=baseMapper.selectOne(queryWrapper);



        return  commodity;
    }
    @Override
    public List<Commodity> selectHotCommodity(){
//        ???????????????
        QueryWrapper<Commodity> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("view_count");
        queryWrapper.last("limit 8");
        return baseMapper.selectList(queryWrapper);

    }

}
