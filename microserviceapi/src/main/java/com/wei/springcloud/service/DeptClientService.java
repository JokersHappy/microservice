package com.wei.springcloud.service;

import com.wei.springcloud.entitys.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 陈伟 on 2019/12/27 0027.
 */
@FeignClient(value = "microservice-dept")
public interface DeptClientService {

    @RequestMapping("/dept/get/{id}")
     Dept get(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
     List<Dept> list();

    @PostMapping("/dept/add")
     boolean add(@RequestBody Dept dept);

}
