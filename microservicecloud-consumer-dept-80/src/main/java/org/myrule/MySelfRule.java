package org.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义的Ribbon负载均衡算法
 */
@Configuration
public class MySelfRule {

    /**
     * 在著配置类上添加了这个注解
     * @RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
     * Ribbon会来使用自定义的负载均衡算法
     *
     */
    @Bean
    public IRule myRule(){
        System.out.println("==========================================>" +
                "MySelfRule" +
                "==========================================>");
        //return new RandomRule();

        //使用自定义的负载均衡算法
        return new RandomRule_ZY();
    }
}
