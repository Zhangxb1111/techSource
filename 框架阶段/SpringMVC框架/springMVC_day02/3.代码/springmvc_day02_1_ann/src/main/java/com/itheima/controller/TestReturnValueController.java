package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/returnValue")
public class TestReturnValueController {


    /**
     *
     * @return
     */
    @RequestMapping("/testShow")
    public String testShow(){
        return "show";
    }

    /**
     *forward:转发
     * 如果写了forward，不会走视图解析器
     * @return
     */
    @RequestMapping("/testShow2")
    public String testShow2(){
        System.out.println(":........");
        return "forward:/success.jsp";
    }
    /**
     *redirect:转发
     * 如果写了redirect，不会走视图解析器
     * @return
     */
    @RequestMapping("/testShow3")
    public String testShow3(){
        System.out.println(":........");
        return "redirect:/success.jsp";
    }



}
