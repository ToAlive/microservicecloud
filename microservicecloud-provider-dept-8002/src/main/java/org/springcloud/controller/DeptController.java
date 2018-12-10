package org.springcloud.controller;

import org.learn.springcloud.pojo.Dept;
import org.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;


    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        System.out.println("===============>/dept/add");
        //return service.add(dept);
        return true;
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        System.out.println("===============>/dept/get/{id}");
        //return service.get(id);
        Dept dept =
                new Dept().setDname("okDName").setDeptno(8001L).setDb_source("cloudDB02");
        return dept;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        System.out.println("===============>/dept/list");

        //return service.list();

        List<Dept> depts = new ArrayList<>();
        Dept dept1 =
                new Dept().setDname("okDName1").setDeptno(8001L).setDb_source("cloudDB02");
        Dept dept2 =
                new Dept().setDname("okDName2").setDeptno(8001L).setDb_source("cloudDB02");
        Dept dept3 =
                new Dept().setDname("okDName3").setDeptno(8001L).setDb_source("cloudDB02");
        Dept dept4 =
                new Dept().setDname("okDName4").setDeptno(8001L).setDb_source("cloudDB02");
        depts.add(dept1);
        depts.add(dept2);
        depts.add(dept3);
        depts.add(dept4);
        return depts;
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
