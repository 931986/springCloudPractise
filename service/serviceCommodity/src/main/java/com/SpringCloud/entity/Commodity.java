package com.SpringCloud.entity;

import com.SpringCloud.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
        @TableName("commodity_center")
        @ApiModel(value = "commodity列表",description = "commodity列表")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Commodity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    public static final String COMMODITY_DRAFT = "Draft";
    public static final String COMMODITY_NORMAL = "Normal";

    @ApiModelProperty(value = "负责人id")
    private String id;

    @ApiModelProperty(value = "负责人id")
    private String sellerId;
    @ApiModelProperty(value = "commodity所属小类别")
    private String subjectId;
    @ApiModelProperty(value = "commodity所属大类")
    private String subjectParentId;
    @ApiModelProperty(value = "commodity标题")
    private String commodityTitle;
    @ApiModelProperty(value = "commodity价格")
    private String commodityPrice;
    @ApiModelProperty(value = "时间统计(这个是备用属性)")
    private String commodityTime;
    @ApiModelProperty(value = "commodity封面")
    private String commodityCover;
    @ApiModelProperty(value = "销售数量")
    private String sellerAmount;
    @ApiModelProperty(value = "浏览数量")
    private String viewCount;
    @ApiModelProperty(value = "乐观锁/版本")
    private String version;
    @ApiModelProperty(value = "commodity状态")
    private String commodityStatus;




}
