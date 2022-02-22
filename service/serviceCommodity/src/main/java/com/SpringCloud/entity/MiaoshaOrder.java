package com.SpringCloud.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@TableName("commodity_center")
@ApiModel(value = "commodity列表",description = "commodity列表")

@Accessors(chain = true)
public class MiaoshaOrder {
    private Long id;
    private Long userId;
    private Long orderId;
    private Long goodsId;
}
