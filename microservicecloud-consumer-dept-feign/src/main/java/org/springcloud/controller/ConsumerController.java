package org.springcloud.controller;

import org.learn.springcloud.pojo.Dept;
import org.learn.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        System.out.println("FeignController=========get");
        return this.deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list()
    {
        System.out.println("FeignController=========list");
        return this.deptClientService.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept)
    {
        System.out.println("FeignController=========add");
        return this.deptClientService.add(dept);
    }
}
