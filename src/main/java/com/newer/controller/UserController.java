package com.newer.controller;

import com.newer.domain.User;
import com.newer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        User user=userService.login(username,password);
        if (user==null){
            model.addAttribute("msg","用户名或密码错误!");
            return "login";
        }
        if (user.getState()==0){
            model.addAttribute("msg","账户被禁用，请与管理员联系");
            return "login";
        }
        session.setAttribute("loginer",user);
        return "index";
    }

    @RequestMapping("/checkname")
    public void checkname(String username, PrintWriter out){
        //方法参数注入响应对象，或输出流代表向客户端响应
        //方法的返回值必须是void
        if (userService.checkName(username)){
            out.print("用户名可以使用");
        }else {
            out.print("该用户名已被注册");
        }
    }

    @ResponseBody//将方法的返回值自动转换成json对象,用响应输出流返回响应主体内容
    @RequestMapping("/findById")
    public User findById(@RequestParam("userid") int userId){
        return userService.findById(userId);
    }

//    @ResponseBody
//    @RequestMapping("/updateUser")
//   public int updateUser(@RequestParam("userid") int userId,
//                          @RequestParam("password") String password){
//        if (userService.updateUser(userId,password)>=1){
//
//        }
//   }

}
