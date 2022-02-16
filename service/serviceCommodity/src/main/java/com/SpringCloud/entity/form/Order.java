package com.SpringCloud.entity.form;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("Order_center")
@ApiModel(value = "order列表",description = "Goods的Jmeter测试Order订单记录")
public class Order {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "des")
    private String description;
    @ApiModelProperty(value = "status")
    private int status;
    @ApiModelProperty(value = "userId")
    private int userId;
}
