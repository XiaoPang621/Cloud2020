package com.baidu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServcerApplication7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServcerApplication7002.class,args);
    }
}
