package com.baidu.cloud.Lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description : 自定义负载均衡轮询规则
 * @Author : WangYaFei
 * @Date: 2022-05-06 16:27
 */
@Component
public class MyLB implements LoadBalancer{
    //原子整数
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next=current > 2147483647 ? 0 :current+1;
        }while (!atomicInteger.compareAndSet(current,next));//如果Current不等于next，那就让current的值更新为next的值
        System.out.println("*****next的值："+next);
        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstance) {
      int index=  getAndIncrement()%serviceInstance.size();//第几次访问

        return serviceInstance.get(index);
    }
}
