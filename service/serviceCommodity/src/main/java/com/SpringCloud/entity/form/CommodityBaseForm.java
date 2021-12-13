package com.SpringCloud.entity.form;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("commodity_center")
@ApiModel(value = "commodity基本信息",description = "commodity列表")

public class CommodityBaseForm implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "负责人id")
    private String sellerId;
    @ApiModelProperty(value = "commodityID")
    private String id;
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
//    @ApiModelProperty(value = "销售数量")
//    private String sellerAmount;
//    @ApiModelProperty(value = "浏览数量")
//    private String viewCount;
//    @ApiModelProperty(value = "乐观锁/版本")
//    private String version;
//    @ApiModelProperty(value = "commodity状态")
//    private String commodityStatus;

}
