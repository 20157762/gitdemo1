package com.newer.controller;

import com.newer.domain.Emp;
import com.newer.domain.User;
import com.newer.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private EmpService empService;


    //RequestMapping:控制器方法被请求
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("控制器hello方法被执行!");
        //返回视图名,默认内部转发
        return "index";
    }

    @RequestMapping("/login")
    public String login(String username,String pwd){
        //请求参数与形参名自动映射
        System.out.println(username+":"+pwd);
        return "index";
    }

    @RequestMapping("/login1")
    public String login1(User user){
        //请求参数与对象属性名自动映射
        //方法参数是对象，该对象自动设置到请求参数作用域
        System.out.println(user.getUsername()+":"+user.getPassword());
        //redirect重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping("/list")
    public String findEmp(Map<String,Object> map){
        //方法参数是Map，代表模型数据集合
        List<Emp> list=empService.findAll();
        map.put("list",list);//将list设置到请求作用域
        return "list";
    }

//    @RequestMapping("/user1")
//    public String findByNP(User user){
//        System.out.println(user.getUsername()+user.getPwd());
//
//        System.out.println(userService.findByNP("admin","111111"));
//        if(userService.findByNP(user.getUsername(),user.getPwd())>=1) {
//            return "index";
//        }else {
//            return "user";
//        }
//    }
//
//    @RequestMapping("/zhuce")
//    public  String zhuCe(User user){
//        if (userService.findByUN(user.getUsername())>=1){
//            return "haveuser";//用户已存在
//        }else{
//            if (userService.addByNP(user.getUsername(),user.getPwd())>=1){
//                return "perfect";//注册成功
//            }
//            else{
//                return "bad";//系统异常
//            }
//        }
//    }
}
