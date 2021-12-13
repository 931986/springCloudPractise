package com.SpringCloud.Dto;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data

public class CommodityDto implements Serializable {
//    private static  final  long
    static final long serialVersionUID = 1L;

    private String id;
    private  String name;
    private BigDecimal price;
    private  String cover;
    private String sellerName;

}
