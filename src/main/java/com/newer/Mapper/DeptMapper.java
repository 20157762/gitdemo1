package com.newer.Mapper;

import com.newer.domain.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeptMapper {

    @Select("select * from dept where deptno=#{deptno}")
    Dept findByNo(@Param("deptno") int deptno);

    @ResultMap(value = "com.newer.Mapper.DeptMapper.dept1")
    @Select("select d.deptno,d.dname,d.loc,empno,ename,sal,hiredate " +
            "from emp e left join dept d on e.deptno=d.deptno ")
    List<Dept> findAll();

    @Insert("insert into dept values(#{deptno},#{dname},#{loc})")
    int addDept(Dept dept);

    @Update("update dept set dname=#{dname},loc=#{loc} where deptno=#{deptno}")
    int updateDept(Dept dept);

    @Delete("delete from dept where deptno=#{deptno}")
    int deleteDept(@Param("deptno") int deptno);
}
