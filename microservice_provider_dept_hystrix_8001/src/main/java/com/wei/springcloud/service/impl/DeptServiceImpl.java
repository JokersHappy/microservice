package com.wei.springcloud.service.impl;

import com.wei.springcloud.dao.DeptDao;
import com.wei.springcloud.entitys.Dept;
import com.wei.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/11/25 0025.
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptDao deptDao;

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public boolean add(Dept dept) {
        return deptDao.aadDept(dept);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
