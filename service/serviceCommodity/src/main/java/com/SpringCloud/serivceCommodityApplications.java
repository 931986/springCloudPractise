package com.SpringCloud;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 如果mybatis中service实现类中加入事务注解，需要此处添加该注解

@MapperScan(basePackages = "com.SpringCloud.mapper")

@EnableDiscoveryClient
@EnableFeignClients

public class serivceCommodityApplications {
    public static void main(String[] args){
        SpringApplication.run(serivceCommodityApplications.class);
    }

}

