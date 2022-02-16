package com.SpringCloud.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data

public class CollectVo   implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String sellerId;

    private String subjectId;

    private String subjectParentId;

    private String commodityTitle;

    private String commodityPrice;

    private String commodityTime;

    private String commodityCover;

    private String sellerAmount;

    private String viewCount;

    private String version;

    private String commodityStatus;
}
