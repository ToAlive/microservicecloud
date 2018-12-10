package springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.learn.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.service.DeptService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    //熔断机制触发后的处理逻辑
    public Dept hystrixMethod(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("id:"+id+ " not found " +
                "Exception,Hystrix来处理了").setDb_source("mysql databases is " +
                "not found");
    }

    //调用服务方法出现异常时触发熔断机制，会调用指定熔断机制的处理逻辑
    @HystrixCommand(fallbackMethod = "hystrixMethod")
    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        System.out.println("===============>/dept/get/{id}");
        //return service.get(id);

        Dept dept = null;
        if(id>10L){
            throw new RuntimeException();
        }else{
            dept = new Dept().setDname("okDName").setDeptno(8001L).setDb_source("cloudDB01");
        }

        return dept;
    }


    @Autowired
	private DiscoveryClient client;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }
}
