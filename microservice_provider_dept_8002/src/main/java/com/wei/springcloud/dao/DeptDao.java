package com.wei.springcloud.dao;

import com.wei.springcloud.entitys.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2019/11/25 0025.
 */

@Mapper
public interface DeptDao {
    public boolean aadDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}
