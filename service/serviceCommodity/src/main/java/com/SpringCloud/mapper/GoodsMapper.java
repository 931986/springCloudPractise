package com.SpringCloud.mapper;


import com.SpringCloud.entity.form.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

//    void reduceGoods(Goods goods);
void reduceGoods(@Param("id") int id);

}
