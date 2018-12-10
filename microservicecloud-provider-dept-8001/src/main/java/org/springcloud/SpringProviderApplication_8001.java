package org.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //这个服务启动后会自动注册到eureka注册中心
//开启发现服务功能 @EnableEurekaClient注解中包含了@EnableDiscoveryClient，应该可用不写
//@EnableDiscoveryClient
public class SpringProviderApplication_8001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringProviderApplication_8001.class,args);
    }
}
