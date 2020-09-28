package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(String username , String password, HttpServletRequest request){
        //取数据库判断是否有次用户，账户密码是否匹配
        //模拟操作
        if("zhangsan".equals(username) && "123".equals(password)){
            //登录成功后将用户信息存储到session中
            request.getSession().setAttribute("username", username);
            System.out.println("登录成功");
            return "redirect:/account/findAll";
        }else{
            System.out.println("登录失败");
            request.getSession().setAttribute("username", null);
            return "redirect:/login.jsp";
        }
    }
}
