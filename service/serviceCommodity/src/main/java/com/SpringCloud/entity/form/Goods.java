package com.SpringCloud.entity.form;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@TableName("Goods_center")
@ApiModel(value = "Good列表",description = "Goods的Jmeter测试")

@Accessors(chain = true)
public class Goods {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "数量")
    private  int num;

}
