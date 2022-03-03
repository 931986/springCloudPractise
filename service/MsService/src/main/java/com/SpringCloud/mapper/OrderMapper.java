package com.SpringCloud.mapper;


import com.SpringCloud.entity.form.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<OrderInfo>  {
}
