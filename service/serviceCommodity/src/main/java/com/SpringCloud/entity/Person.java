package com.SpringCloud.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@TableName("person_center")
@ApiModel(value = "commodity列表",description = "commodity列表")
//@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Person {

    private static final long serialVersionUID=1L;



    @ApiModelProperty(value = "个人姓名")
    private String name;

    @ApiModelProperty(value = "个人简介")
    private String intro;

    @ApiModelProperty(value = "个人描述")
    private String des;

    @ApiModelProperty(value = "个人权限 1，2，3，4")
    private Integer level;

    @ApiModelProperty(value = "个人头像")
    private String avatar;
    @ApiModelProperty(value = "个人id")
    private Integer id;

    @ApiModelProperty(value = "排序")
    private Integer sort;

//    @ApiModelProperty(value = "个人注册时间",example = "2020-01-01")
//    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
//    private Date joinDate;

    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除")
    @TableField("is_deleted")
//    is_deleted
    @TableLogic
    private Boolean deleted;

}
