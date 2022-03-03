package com.SpringCloud.entity.form;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

//这个包含的信息最多
//registerinfo包含必须具有的信息，其余设置成默认值
@Data
@TableName(value = "User_Center")
@ApiModel(value = "user",description = "这是用于user信息存储的数据库")
//@EqualsAndHashCode(callSuper = true)
//这个注解是当继承时候
@Accessors(chain = true)
public class User {
    private static final long serialVersionUID = 1L;
//    用户:id name  phone，pass,email,
//      des,wecha,   des,avatar
//    是否禁用  逻辑删除 个人权限 level  account sex age
    @ApiModelProperty(value = "user")
    private int id;
    @ApiModelProperty(value = "个人名称")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "密码")
    private String pass;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "wechat")
    private String wechat;
    @ApiModelProperty(value = "个人简介")
    private String des;
    @ApiModelProperty(value = "个人头像")
    private String avatar;
    @ApiModelProperty(value = "个人余额")
    private float account;
    @ApiModelProperty(value = "性别")
    private int sex;
    @ApiModelProperty(value = "年龄")
    private int age;
    @ApiModelProperty(value = "权限")
    private int level;
    @ApiModelProperty(value = "是否禁用")
    @TableField("is_disabled")
    private Boolean is_disabled;
    @ApiModelProperty(value = "逻辑删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean is_deleted;








}
