package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestRequestBodyController {


    /**
     * @RequestBody 获取参数时直接字符串 id=4&name=lisi
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody(required = true)  String body){
        System.out.println(body);
        return "show";
    }

    /**
     * @ResponseBody  返回页面就是一个字符串或者是一般Json
     * @param id
     * @return
     */
    @RequestMapping("/testResponseBody.do")
    @ResponseBody
    public User testResponseBody(Integer id){

        User user = new User();
        user.setId(1);
        user.setAge(200);
        user.setUsername("zhangsan");
        return user;
    }
}
