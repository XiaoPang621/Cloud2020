package com.baidu.springCloud.Service;

import com.baidu.cloud.Entitys.CommonResult;
import com.baidu.cloud.Entitys.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description : PaymentFeignService
 * @Author : WangYaFei
 * @Date: 2022-08-19 16:08
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //标明这是一个调用者接口，value中写的是服务提供者的服务注册名称
public interface PaymentFeignService {
    @PostMapping("/login.in")
    public CommonResult<User> login(@RequestBody User user);
}
