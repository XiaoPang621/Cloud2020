package com.baidu.springCloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//nacos注册中心注解
/*@EnableDiscoveryClient*/
@EnableEurekaClient
@EnableDiscoveryClient //服务发现注解
@MapperScan("com.baidu.springCloud.Mapper")
public class cloudProviderPayment8003Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(cloudProviderPayment8003Application.class, args);
        //查看容器里面的组件
      /*  String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);//打印ioc容器中的所有组件名称
        }*/
    }
}
