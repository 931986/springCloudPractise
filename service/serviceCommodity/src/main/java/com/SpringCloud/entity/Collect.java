package com.SpringCloud.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
//@EqualsAndHashCode(callSuper = true)
@TableName("commodity_collect")
@ApiModel(value="CourseCollect对象", description="课程收藏")
@Accessors(chain = true)


public class Collect {



    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品ID")
    private String commodityId;

    @ApiModelProperty(value = "收藏者ID")
    private String memberId;
}
