package com.baidu.springCloud.Controller;

import com.baidu.cloud.Entitys.CommonResult;
import com.baidu.cloud.Entitys.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class inderController {
    //public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://consul-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consulIndex.ins")
    public String login(User user) throws RestClientException {

        try {
            return restTemplate.getForObject(PAYMENT_URL+"/login",String.class);//只传递post请求
        } catch (RestClientException e) {
            throw new RestClientException("没有连接到服务提供者");
            /*e.printStackTrace();*/
        }

    }
}
