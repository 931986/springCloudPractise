package com.SpringCloud.entity;


import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
        @TableName("trade_order")
        @ApiModel(value = "order",description = "订单记录")
public class Order {

    private static final long serialVersionUID=1L;

//    ###  order内部的数据
//###  订单号
//### 商品id
//### 商品名称
//### 商品封面
//### 负责人名称
//###  购买者id
//### 购买者名称### 购买者手机号码
//### 订单金额
//### 支付类型（1，支付宝，2.银联）
//###  订单状态
//### 逻辑删除

    @ApiModelProperty(value = "订单号")
    private  String orderId;
    @ApiModelProperty(value = "商品id")
    private  String  commodityId;
    @ApiModelProperty(value = "商品name")
    private  String  commodityName;
    @ApiModelProperty(value = "商品cover")
    private  String  commodityCover;
    @ApiModelProperty(value = "负责人名称")
    private  String  sellerName;
    @ApiModelProperty(value = "购买者id")
    private  String  buyerId;
    @ApiModelProperty(value = "购买者name")
    private  String  buyerName;
    @ApiModelProperty(value = "购买者Phone")
    private  String  buyerPhone;
    @ApiModelProperty(value = "订单金额")
    private  String  orderAmount;
    @ApiModelProperty(value = "支付类型")
    private  String   payChoice;
    @ApiModelProperty(value = "支付状态")
    private  String   payStatus;
    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private  String   logicDelete;





}
