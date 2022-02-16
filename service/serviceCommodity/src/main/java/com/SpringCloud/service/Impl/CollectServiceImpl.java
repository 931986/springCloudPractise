package com.SpringCloud.service.Impl;

import com.SpringCloud.entity.Collect;
import com.SpringCloud.entity.Commodity;
import com.SpringCloud.entity.form.CommodityBaseForm;
import com.SpringCloud.entity.vo.CollectVo;
import com.SpringCloud.mapper.CollectMapper;
import com.SpringCloud.service.CollectService;
import com.SpringCloud.service.CommodityService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
    @Autowired
    private CommodityService commodityService;

    @Override
    public boolean isCollect(String commodityId, String memberId) {
QueryWrapper<Collect> queryWrapper=new QueryWrapper<>();
queryWrapper.eq("commodity_id",commodityId).eq("member_id",memberId);
Integer count=baseMapper.selectCount(queryWrapper);
        return count>0;
    }

    @Override
    public boolean saveCollect(String commodityId, String memberId) {
        if(!isCollect(commodityId,memberId)){
            Collect commodityCollect=new Collect();
            commodityCollect.setCommodityId(commodityId);
            commodityCollect.setMemberId(memberId);
            this.save(commodityCollect);

        }else{
            removeCollect(commodityId,memberId);
        }
        return true;

    }

    @Override
    public void removeCollect(String commodityId, String memberId) {
        if(this.isCollect(commodityId,memberId)){
            QueryWrapper<Collect> queryWrapper=new QueryWrapper();
            queryWrapper.eq("commodity_id",commodityId).eq("member_id",memberId);
            this.remove(queryWrapper);
        }

    }

    @Override

    public List<CollectVo> selectCollect(String memberId) {
        QueryWrapper<Collect> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("member_id",memberId);
        List<CollectVo>  memberCollectInfo=new ArrayList<>();
        CollectVo tmp=new CollectVo();
      List<Collect> member_Commodity=baseMapper.selectList(queryWrapper);

        for(Collect collect:member_Commodity){
            System.out.println(Integer.parseInt(collect.getCommodityId()));

       Commodity temp=commodityService.GetCommodityByCommodityId(collect.getCommodityId());
        if(temp==null){
         continue;
         }
   BeanUtils.copyProperties(temp,tmp);
            memberCollectInfo.add(tmp);
        }
//        List<CollectVo> res=baseMapper.selectPageByMemberId(memberId);
//        System.out.println(res);
        return memberCollectInfo;
    }
}
