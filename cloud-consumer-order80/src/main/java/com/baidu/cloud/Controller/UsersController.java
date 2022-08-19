package com.baidu.cloud.Controller;

import com.baidu.cloud.Entitys.CommonResult;
import com.baidu.cloud.Entitys.User;
import com.baidu.cloud.Lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("Order")
@Slf4j
public class UsersController {

    //public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("user.ins")
    public CommonResult<User> login(User user) throws RestClientException {

        try {
            return restTemplate.postForObject(PAYMENT_URL+"/user/login.in",user,CommonResult.class);//只传递post请求
        } catch (RestClientException e) {
            throw new RestClientException("没有连接到服务提供者");
            /*e.printStackTrace();*/
        }

    }
    @GetMapping("get/{id}")
    public CommonResult<User> getbyid(@PathVariable("id") long id){
        return restTemplate.getForObject(PAYMENT_URL+"/user/getbyid.in/"+id,CommonResult.class);//只是传递Get请求
    }
    @GetMapping("getEntity/{id}")
    public CommonResult<User> getEntity(@PathVariable("id") long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/user/getbyid.in/" + id, CommonResult.class);//只是传递Get请求
        if(entity.getStatusCode().is2xxSuccessful()){//2xx:返回状态码，2xx成功（200）getStatusCode：获取状态码
            return entity.getBody();
        }else{
            return new CommonResult<>(404,"操作失败");
        }
    }
    @GetMapping("getEntitys/{id}")
    public CommonResult<User> getEntitys(@PathVariable("id") long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/user/getbyid.in/"+id,CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){//2xx:返回状态码，2xx成功（200）getStatusCode：获取状态码
            return entity.getBody();
        }else{
            return new CommonResult<>(404,"操作失败");
        }
    }

    /**
    * @description : 自定义负载均衡规则
    * @author : WangYaFei
    * @date: 2022/8/18 17:35
    */
    @GetMapping(value="/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances==null||instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance=loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/LB",String.class);
    }
}
