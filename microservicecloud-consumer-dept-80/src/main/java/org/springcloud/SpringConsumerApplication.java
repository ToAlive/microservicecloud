package org.springcloud;

import org.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
/**
 * 这个注解的作用是用来发现注册在注册中心里面的服务,
 * @EnableEurekaClient 注解里面使用了 @EnableDiscoveryClient
 * 这里其实可用使用@EnableDiscoveryClient
 */
//@EnableEurekaClient
@EnableDiscoveryClient
//这个注解的作用是在这个服务启动的时候去加载,自定义的Ribbon配置类使其生效
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class SpringConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConsumerApplication.class,args);
    }
}
