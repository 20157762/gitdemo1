package com.newer.service;

import com.newer.domain.Dept;
import com.newer.Mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional (propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,rollbackFor = Exception.class)
    @Override
    public int deleteDept(int deptno) {
        return deptMapper.deleteDept(deptno);
    }

    @Override
    public Dept findByNO(int deptno) {
        return deptMapper.findByNo(deptno);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
