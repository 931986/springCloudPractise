package com.SpringCloud.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


//@EqualsAndHashCode(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data

@ApiModel(value = "Good列表",description = "Goods页面信息")
public class GoodsVo extends Goods {

    @ApiModelProperty(value = "name")
    private String goodsName;

    @ApiModelProperty(value = "title")
    private String goodsTitle;
    @ApiModelProperty(value = "img")
    private String goodsImg;
    @ApiModelProperty(value = "des")
    private String goodsDetail;
    @ApiModelProperty(value = "price")
    private String goodsPrice;



//          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
//            `goods_name` varchar(30) DEFAULT NULL COMMENT '商品名称',
//            `goods_title` varchar(64) DEFAULT NULL COMMENT '商品标题',
//            `goods_img` varchar(64) DEFAULT NULL COMMENT '商品图片',
//            `goods_detail` longtext COMMENT '商品详情',
//            `goods_price` decimal(10,2) DEFAULT NULL,
//                                `goods_stock` int(11) DEFAULT '0' COMMENT '商品库存，-1表示没有限制',
}
