package org.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
//启动服务监控
@EnableHystrixDashboard
public class HystrixAdshboard {

    public static void main(String[] args) {
        SpringApplication.run(HystrixAdshboard.class,args);
    }
}
