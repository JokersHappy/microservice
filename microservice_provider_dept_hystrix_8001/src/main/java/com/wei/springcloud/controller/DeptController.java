package com.wei.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wei.springcloud.entitys.Dept;
import com.wei.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/11/25 0025.
 */
@RestController
public class DeptController {
    @Autowired
    DeptService deptService;

    @Autowired
    DiscoveryClient discoveryClient;


    @RequestMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrix_get")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("改ID:" + id + "未找到");
        }
        return dept;
    }

    public Dept hystrix_get(@PathVariable("id") Long id) {
        return new Dept().setId(id).setName("找到对应信息").setData_source("no this database in mysql");
    }

    public List<Dept> hystrix_list() {
        List<Dept> list = new ArrayList<>();
        list.add(new Dept().setName("没有对应的信息，Consumer客户端提供的降级信息，此刻服务provider已关闭").setData_source("no this database in mysql"));
        return list;
    }

    @RequestMapping("/dept/list")
    @HystrixCommand(fallbackMethod = "hystrix_list")
    public List<Dept> list(){
        return deptService.list();
    }
}
