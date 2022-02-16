package com.SpringCloud.service;

import com.SpringCloud.entity.Collect;
import com.SpringCloud.entity.Commodity;
import com.SpringCloud.entity.CommodityDto;
import com.SpringCloud.entity.form.CommodityBaseForm;
import com.SpringCloud.entity.vo.CollectVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CollectService extends IService<Collect> {
    public boolean isCollect(String commodityId,String memberId);
    public boolean  saveCollect(String commodityId,String memberId);

    public void removeCollect(String commodityId,String memberId);
    public List<CollectVo> selectCollect(String memberId);
//                                       isCollect save  select  remove
}
