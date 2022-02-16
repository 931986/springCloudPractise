package com.SpringCloud.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="qcloud")
public class vodProperties {
    private String SecretId;
    private  String  Secretkey;
}
