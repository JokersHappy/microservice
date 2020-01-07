package com.wei.springcloud.service;

import com.wei.springcloud.entitys.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by 陈伟 on 2020/1/7 0007.
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(@PathVariable("id") Long id) {
                return new Dept().setId(id).setName("没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已关闭").setData_source("no this database in mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(@RequestBody Dept dept) {
                return false;
            }
        };
    }
}
