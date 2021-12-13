package com.SpringCloud.entity;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
//@TableName("commodity_center")
@ApiModel(value = "commodity列表",description = "commodity列表")

@Accessors(chain = true)
public class MsEnitity {
    int id;
    String name;
}
