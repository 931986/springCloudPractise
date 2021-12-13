package com.SpringCloud.entity;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data

public class CommodityDto implements Serializable {
//    private static  final  long
    static final long serialVersionUID = 1L;

    private String id;
    private  String CommodityTitle;
    private BigDecimal CommodityPrice;
    private  String CommodityCover;
    private String sellerName;

}
