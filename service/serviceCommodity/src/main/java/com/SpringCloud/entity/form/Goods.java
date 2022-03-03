package com.SpringCloud.entity.form;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("Goods_seckill_center")
@ApiModel(value = "Good列表",description = "Goods的Jmeter测试")

@Accessors(chain = true)
public class Goods implements Serializable {
    @ApiModelProperty(value = "id")
    private long id;
    @ApiModelProperty(value = "goods_id")
    private long goodsId;

    @ApiModelProperty(value = "数量")
    private  int num;
    @ApiModelProperty(value = "价格")
    private  double seckillPrice;
    @ApiModelProperty(value = "开始时间")
    private Date startDate;
    @ApiModelProperty(value = "结束时间")
    private  Date endDate;
    @ApiModelProperty(value = "版本")
    private  int version;

//    `seckill_price` decimal(10,2) DEFAULT '0.00' COMMENT '秒杀价',
//            `stock_count` int(11) DEFAULT NULL COMMENT '库存数量',
//            `start_date` datetime DEFAULT NULL COMMENT '秒杀开始时间',
//            `end_date` datetime DEFAULT NULL COMMENT '秒杀结束时间',
//            `version` int(11) DEFAULT NULL COMMENT '并发版本控制',

}
