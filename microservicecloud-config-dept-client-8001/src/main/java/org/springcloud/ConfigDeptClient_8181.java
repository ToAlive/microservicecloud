package org.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigDeptClient_8181 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigDeptClient_8181.class,args);
    }
}
