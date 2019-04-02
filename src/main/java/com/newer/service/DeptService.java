package com.newer.service;

import com.newer.domain.Dept;

import java.util.List;

public interface DeptService {

    int addDept(Dept dept);

    int updateDept(Dept dept);

    int deleteDept(int deptno);

    Dept findByNO(int deptno);

    List<Dept> findAll();
}
