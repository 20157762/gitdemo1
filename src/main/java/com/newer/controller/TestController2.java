package com.newer.controller;


import com.newer.domain.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/demo")
@SessionAttributes("emp1")
public class TestController2 {

    @RequestMapping("/test1")
    public String test1(@ModelAttribute("emp1")Emp emp){
        emp.setEname("demo/test1处理:"+emp.getEname());
        return "test";
    }
}
