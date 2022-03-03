package com.SpringCloud.entity;




import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

//这个包含的信息最多
//registerinfo包含必须具有的信息，其余设置成默认值
@Data

@ApiModel(value = "register",description = "user必备的信息")
//@EqualsAndHashCode(callSuper = true)
//这个注解是当继承时候
@Accessors(chain = true)
public class loginInfo {
    private static final long serialVersionUID = 1L;
    //    用户 id name  手机号 ，密码
//    chat 邮箱 签名 默认头像
//    是否禁用 逻辑删除 个人权限    余额 性别 年龄
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    @NotNull(message = "id 不能为 null")
    @ApiModelProperty(value = "user")
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private int id;

    @ApiModelProperty(value = "userAccount/phone/email三选一")
    private String userInfo;
    @ApiModelProperty(value = "密码")
    private String pass;
    @ApiModelProperty(value = "验证码")
    private String code;

//    @ApiModelProperty(value = "个人简介")
//    private String des;
//    @ApiModelProperty(value = "个人头像")
//    private String avatar;
//    @ApiModelProperty(value = "个人余额")
//    private float account;
//    @ApiModelProperty(value = "性别")
//    private int sex;
//    @ApiModelProperty(value = "年龄")
//    private int age;
//    @ApiModelProperty(value = "是否禁用")
//    @TableField("is_disabled")
//    private Boolean is_disabled;
//    @ApiModelProperty(value = "逻辑删除")
//    @TableField("is_deleted")
//    @TableLogic
//    private Boolean is_deleted;


}
