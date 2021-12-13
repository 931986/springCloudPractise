package com.SpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//禁止自动注入数据源

public class apiGateApplication {
    public static  void main(String[] aegs){
        SpringApplication.run(apiGateApplication.class);
    }
}
