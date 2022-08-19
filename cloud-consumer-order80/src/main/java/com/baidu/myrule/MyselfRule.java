package com.baidu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description : MyselfRule
 * @Author : WangYaFei
 * @Date: 2022-04-28 14:58
 */
@Configuration
//负载均衡规则自定义
public class MyselfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();// Ribbon默认是轮询，我自定义为随机
    }
}
