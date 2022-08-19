package com.baidu.cloud.Lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description : LoadBalancer
 * @Author : WangYaFei
 * @Date: 2022-05-06 16:25
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstance);
}
