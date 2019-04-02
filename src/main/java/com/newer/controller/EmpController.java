package com.newer.controller;

import com.newer.domain.Emp;
import com.newer.service.EmpService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//RestController=controller+ResponseBody
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Emp> findAll(){
        return empService.findAll();
    }

    @GetMapping("/{empno}")
    public Emp findById(@PathVariable("empno") int empno){
        //PathVariable将路径变量值注入方法参数
        return empService.findById(empno);
    }
    @PostMapping
    public Map<String,Object> addEmp(Emp emp){
        int result = empService.addEmp(emp);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }
    //无法修改关联属性值
//    @PutMapping("/{empno}")
//    public Map<String,Object> updateEmp(@PathVariable("empno") int empno,@RequestBody Emp emp){
//        emp.setEmpNo(empno);
//        int result = empService.addEmp(emp);
//        Map<String,Object> map = new HashMap<>();
//        map.put("result",result);
//        return map;
//    }
    @PutMapping("/{empno}")
    public Map<String,Object> updateEmp(@PathVariable("empno") int empno,
                                        Emp emp){
        emp.setEmpNo(empno);
        int result=empService.updateEmp(emp);
        Map<String,Object> map=new HashMap<>();
        map.put("result",result);
        return map;
    }
    @DeleteMapping("/{empno}")
    public Map<String,Object> deleteEmp(@PathVariable("empno") int empno){
        int result = empService.deleteEmp(empno);
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        return map;
    }
}
