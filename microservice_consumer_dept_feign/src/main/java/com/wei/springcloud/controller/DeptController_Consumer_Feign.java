package com.wei.springcloud.controller;

import com.wei.springcloud.entitys.Dept;
import com.wei.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2019/12/27 0027.
 */
@RestController
public class DeptController_Consumer_Feign {

    @Autowired
    private DeptClientService clientService;

    @PostMapping("/consumer/dept/add")
    public boolean add(@RequestBody Dept dept){
        return this.clientService.add(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return clientService.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return clientService.list();
    }

}
