package org.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka_Service_Registry_7002 {

    public static void main(String[] args) {
        SpringApplication.run(Eureka_Service_Registry_7002.class,args);
    }
}
