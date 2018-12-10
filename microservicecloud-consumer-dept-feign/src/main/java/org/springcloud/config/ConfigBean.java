package org.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class ConfigBean {

    //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具
    @LoadBalanced  //负载均衡默认是使用轮询机制
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate;
    }

    /**
     * MySelfRule类中的IRule组件和这里的IRule组件
     * 如果bean的名字不一样，spring容器会加载两个IRule
     * 组件的实例，会导致报错，没用一个首先bean
     */
    //指定一种负载均衡的算法，替换调默认的轮询算法
    @Bean
    public IRule myRule(){
        //使用Ribbon负载均衡随机的算法
        //return new RandomRule();

         // RetryRule算法：在服务注册中心有三个微服务的实例A B C，RetryRule采用的也是轮询算法
         // 只不过，如果其中B服务挂了，那么RetryRule在默认在三个轮询，就会将挂了的B服务排除调用
         // 不再访问B服务
         //一次轮询： A B C
         // 二次轮询： A B C
         // 三次轮询： A B C
         //四次轮询就不在访问挂调的B服务： A C
         //
        return new RetryRule();
    }
}
