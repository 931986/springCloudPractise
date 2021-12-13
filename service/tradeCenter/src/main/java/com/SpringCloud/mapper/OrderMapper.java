package com.SpringCloud.mapper;

import com.SpringCloud.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
