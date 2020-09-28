package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/testSession")
//一般用来保存中要的信息（账号的信息）
@SessionAttributes(value = {"username","password"})
public class TestSessionAttribute {
    /**
     * 将属性值添加session域中
     */
    @RequestMapping("/testPut")
    public String testPut(Model model){
        model.addAttribute("username","zhangsan");
        model.addAttribute("password","123");
        return "show";
    }

    /**
     * 从session域中获取信息
     */
    @RequestMapping("/testGet")
    public String testGet(ModelMap modelMap){
        System.out.println(modelMap.get("username"));
        System.out.println(modelMap.get("password"));
        return "show";
    }

    /**
     * 清除session
     * @param sessionStatus
     * @return
     */
    @RequestMapping("/testClean")
    public String testClean(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "show";
    }
}
