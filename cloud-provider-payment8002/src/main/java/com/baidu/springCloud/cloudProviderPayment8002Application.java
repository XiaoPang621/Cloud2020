package com.baidu.springCloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//nacos注册中心注解
/*@EnableDiscoveryClient*/
@EnableEurekaClient
@MapperScan("com.baidu.springCloud.Mapper")
public class cloudProviderPayment8002Application {
    public static void main(String[] args) {
        SpringApplication.run(cloudProviderPayment8002Application.class,args);
    }
}
