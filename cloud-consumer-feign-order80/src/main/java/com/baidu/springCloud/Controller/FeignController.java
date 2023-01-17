package com.baidu.springCloud.Controller;

import com.baidu.cloud.Entitys.CommonResult;
import com.baidu.cloud.Entitys.User;
import com.baidu.springCloud.Service.PaymentFeignService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description : FeignController
 * @Author : WangYaFei
 * @Date: 2022-08-24 15:51
 */
@RestController
@FeignClient
public class FeignController {

    //用户服务提供者接口
    @Resource
    private PaymentFeignService paymentFeignService;

    //调用服务提供者的登录方法
    /**
    * @description : 
    * @author : WangYaFei
    * @date: 2022/8/26 17:50
    */
    @PostMapping("/login.in")
    public CommonResult<User> getByiD() {
        User user=new User();
        CommonResult<User> login = paymentFeignService.login(user);
        return login;
    }
}
