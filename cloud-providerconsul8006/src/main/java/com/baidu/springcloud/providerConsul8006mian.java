package com.baidu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class providerConsul8006mian {
    public static void main(String[] args) {
        SpringApplication.run(providerConsul8006mian.class,args);
    }
}
