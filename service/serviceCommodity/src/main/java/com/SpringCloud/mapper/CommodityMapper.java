package com.SpringCloud.mapper;

import com.SpringCloud.entity.Commodity;
import com.SpringCloud.entity.vo.CollectVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommodityMapper extends BaseMapper<Commodity> {

}

