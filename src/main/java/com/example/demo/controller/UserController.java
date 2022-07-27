package com.example.demo.controller;


import com.example.demo.po.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

//跳转至登陆页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

//相关登录操作
    @RequestMapping("/Login")
    public String doLogin(User user, Model model, HttpServletRequest request){
        User u = userService.doLogin(user);
        if(u==null){
            model.addAttribute("msg","用户名或者密码错误，请检查！");
            return "login";
        }
        else{
            request.getSession().setAttribute("user",user);
            return "redirect:findBookAll";
        }
    }

//    跳转至注册页面
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

//    相关注册操作
    @RequestMapping("/Register")
    public String doRegister(User user,Model model){
//        判断用户名是否已经存在
        User user1 = userService.findByUserName(user.getUname());
        if (user1 == null){
            userService.doRegister(user);
            model.addAttribute("msg","账号注册成功，请登录！");
            return "login";
        }else {
            model.addAttribute("msg","用户名已经存在！");
            return "register";
        }
    }

//    退出登录页面
    @RequestMapping("/Logout")
    public String Logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }
}
