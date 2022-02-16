package com.SpringCloud.mapper;


import com.SpringCloud.entity.form.Goods;
import com.SpringCloud.entity.form.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper< Order>  {
}
