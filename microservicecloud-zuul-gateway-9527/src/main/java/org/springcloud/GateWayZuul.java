package org.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//开启Zuul代理
@EnableZuulProxy
public class GateWayZuul {
    public static void main(String[] args) {
        SpringApplication.run(GateWayZuul.class,args);
    }

}
