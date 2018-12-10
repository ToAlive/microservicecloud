package org.learn.springcloud.service;

import feign.hystrix.FallbackFactory;
import org.learn.springcloud.pojo.Dept;
import org.springframework.stereotype.Component;

import java.util.List;

@Component //一定要加上这个注解
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
               Dept dept = new Dept();
               dept.setDeptno(id);
               dept.setDname("microservicecloud-provider-dept-8001 已关闭");
               dept.setDb_source("null");
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
