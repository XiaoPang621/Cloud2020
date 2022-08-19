package com.baidu.springCloud.Controller;

import com.baidu.cloud.Entitys.CommonResult;
import com.baidu.cloud.Entitys.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j  //Springboot自带的日志采集插件
/*@RequestMapping("/user")*/
public class PayUserController {

  /*  @Value("${spring.datasource.url}")
    private String info;*/
   /* @Autowired
    private UserService userService;*/

    @Value("${server.port}")
    private String ServerPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @PostMapping("/login.in")
    //@RequestBody 接收来自请求中json类型的参数
    public CommonResult<User> login(@RequestBody User user){
        CommonResult<User> s=new CommonResult<User>();
        s.setCode(404);
        s.setMessage("查询成功");
        System.err.println("查询结果："+user+",端口号："+ServerPort);
        //s.setData(userService.findbypage());
        return s;
    }
    @ResponseBody
    @GetMapping("/getbyid.in/{id}")
    public CommonResult<User> getbyid(@PathVariable("id") long id){
        CommonResult<User> s=new CommonResult<User>();
        s.setCode(200);
        s.setMessage("查询成功");
        System.err.println("参数结果："+id+",端口号："+ServerPort);
        return s;
    }
  /*  @GetMapping(value = "/hello.in")
    public String hello(){
        return info;
    }*/
    @GetMapping("/discovery")
    @ResponseBody
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.err.println("端口号："+instance.getServiceId()+"/"+instance.getHost()+"/"+instance.getPort()+"/"+instance.getUri());

        }
        return this.discoveryClient;
    }
    @GetMapping("/payment/LB")
    public String getPaymentLB(){
        return ServerPort;
    }
}
