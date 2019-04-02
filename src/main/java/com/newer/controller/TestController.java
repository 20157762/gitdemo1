package com.newer.controller;

import com.newer.domain.Emp;
import com.newer.domain.Student;
import com.newer.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
@SessionAttributes({"emp1","emp2"})
public class TestController {
    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/{id:\\d{4}}",method = RequestMethod.GET)
    public ModelAndView test1(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("id",id);
        modelAndView.setViewName("test");
        return modelAndView;

    }

    @RequestMapping(value = "/test2",params = "username=admin")
    public String test2(){
        System.out.println("test2被执行！admin！");
        return "test";
    }

    @RequestMapping(value = "/test2",params = "username!=admin")
    public String test3(){
        System.out.println("test3被执行！！");
        return "test";
    }

    @RequestMapping("/test3")
    public String test4(Student student){
        System.out.println(student.getStuName());
        student.getAddesss().forEach(addesss -> {
            System.out.println(addesss.getCity());
        });
        return "test";
    }
    @ModelAttribute("emp1")
    public Emp getEmp(){
        //ModeAttribute注解在方法上，该方法没有RequestMapping
        //表示该方法在当前控制器类的任何控制器方法前执行
        //并且方法返回值放入ModelMap
        System.out.println("getEmp方法被执行");
        return empService.findById(7788);
    }

    @ModelAttribute("emp2")
    @RequestMapping("/test4")
    public Emp getEmp2(){
        //方法返回值放入ModelMap,方法跳转到请求url对应视图
        return empService.findById(7937);
    }

    @RequestMapping("/test5")
    public String getEmp3(@ModelAttribute("emp1")Emp emp1){
        emp1.setEname("test5处理:"+emp1.getEname());
        return "test/test4";
    }

    @RequestMapping("/test6")
    public String test5(){
        return "redirect:/demo/test1";
    }
}
