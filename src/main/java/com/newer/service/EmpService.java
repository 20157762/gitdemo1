package com.newer.service;

import com.newer.domain.Emp;

import java.util.List;

public interface EmpService {

    int addEmp(Emp emp);

    int updateEmp(Emp emp);

    int deleteEmp(int empno);

    Emp findById(int empno);

    List<Emp> findAll();
}
