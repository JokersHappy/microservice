package com.wei.springcloud.controller;

import com.wei.springcloud.entitys.Dept;
import com.wei.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){

        return deptService.add(dept);
    }

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @RequestMapping("/dept/discovery")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();

        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("MICROSERVICE-DEPT");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            System.out.println(serviceInstance.getServiceId() +"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort());
        }

        return this.discoveryClient;
    }
}
