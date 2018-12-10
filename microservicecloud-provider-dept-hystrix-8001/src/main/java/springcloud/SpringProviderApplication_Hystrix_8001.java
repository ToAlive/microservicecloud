package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient  //这个服务启动后会自动注册到eureka注册中心
//开启发现服务功能 @EnableEurekaClient注解中包含了@EnableDiscoveryClient，应该可用不写
//@EnableDiscoveryClient
//启用Hystrix熔断组件
@EnableHystrix
public class SpringProviderApplication_Hystrix_8001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringProviderApplication_Hystrix_8001.class,args);
    }
}
