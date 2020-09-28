package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/print")
    public String print(){
        System.out.println("打印");
        return "show";
    }

//    @ModelAttribute
////    public void showModel(){
////        System.out.println("showModel");
////    }
    @ModelAttribute
    public void showModel(String username, Map<String ,User> map){
        //模仿去数据库中查询了一个用户
        User a = getByName(username);
        map.put("abc",a);
        System.out.println("showModel"+a);
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User  user){
        // 如果没有传递某个参数， 会从@ModelAttribute标记的方法获取参数值，进行赋值
        System.out.println("testModelAttribute"+ user);
        return "show";
    }


    /**
     * 用来模仿根据姓名查询用户
     * @return
     */
    public User getByName(String name){
        User user = new User();
        user.setId(5);
        user.setUsername("maliu");
        user.setAge(30);
        return user;
    }
}
