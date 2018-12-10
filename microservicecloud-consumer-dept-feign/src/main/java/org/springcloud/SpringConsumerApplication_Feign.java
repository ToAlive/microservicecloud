package org.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/**
 * 这个注解的作用是用来发现注册在注册中心里面的服务,
 * @EnableEurekaClient 注解里面使用了 @EnableDiscoveryClient
 * 这里其实可用使用@EnableDiscoveryClient
 */
//@EnableEurekaClient
@EnableDiscoveryClient
//启用Feign组件
@EnableFeignClients(basePackages = {"org.learn.springcloud"})
public class SpringConsumerApplication_Feign {

    public static void main(String[] args) {
        SpringApplication.run(SpringConsumerApplication_Feign.class,args);
    }
}
