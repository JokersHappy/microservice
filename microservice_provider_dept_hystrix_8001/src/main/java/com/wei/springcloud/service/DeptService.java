package com.wei.springcloud.service;

import com.wei.springcloud.entitys.Dept;

import java.util.List;

/**
 * Created by Administrator on 2019/11/25 0025.
 */
public interface DeptService {
    public Dept get(Long id);

    public boolean add(Dept dept);

    public List<Dept> list();

}
