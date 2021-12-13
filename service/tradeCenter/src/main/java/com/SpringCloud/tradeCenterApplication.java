package com.SpringCloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.SpringCloud"})
@EnableDiscoveryClient
@EnableFeignClients


public class tradeCenterApplication {
    public static  void main(String[] args){
        SpringApplication.run(tradeCenterApplication.class);
    }
}
