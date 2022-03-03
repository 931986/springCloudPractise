package com.SpringCloud.entity.form;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("OrderInfo_center")
@ApiModel(value = "order列表",description = "Goods的Jmeter测试Order订单记录")
public class OrderInfo {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "des")
    private String description;
    @ApiModelProperty(value = "userId")
    private long userId;
    @ApiModelProperty(value = "邮寄地址编号")
    private String  deliveryAddrId;
    @ApiModelProperty(value = "status")
    private String goodsName;
    @ApiModelProperty(value = "status")
    private Integer goodsCount;
    @ApiModelProperty(value = "status")
    private Double goodsPrice;
    @ApiModelProperty(value = "status")
    private Integer orderChannel;
    @ApiModelProperty(value = "status")
    private Integer status;

}
