package com.baidu.springCloud.Controller;

import com.baidu.cloud.Entitys.CommonResult;
import com.baidu.cloud.Entitys.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
/*@RequestMapping("/user")*/
public class PayUserController {

  /*  @Value("${spring.datasource.url}")
    private String info;*/
   /* @Autowired
    private UserService userService;*/

    @Value("${server.port}")
    private String ServerPort;
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
    @GetMapping("/payment/LB")
    public String getPaymentLB(){
        return ServerPort;
    }
}
