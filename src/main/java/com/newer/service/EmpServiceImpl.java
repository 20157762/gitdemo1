package com.newer.service;

import com.newer.domain.Emp;
import com.newer.Mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class EmpServiceImpl implements EmpService{

    //@Resource
    @Autowired//按名称自动绑定
    private EmpMapper empMapper;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int deleteEmp(int empno) {
        return empMapper.deleteEmp(empno);
    }

    @Override
    public Emp findById(int empno) {
        return empMapper.findById(empno);
    }

    @Override
    public List<Emp> findAll() {
        return empMapper.findAll();
    }
}
