package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestRestFul {

    /**
     *
     * 通过路径请求，默认get请求
     * @PathVariable("id"):把路径中的属性映射参数中
     * @param id
     * @return
     */
    @RequestMapping(value = "/testOperate/{id}",method = RequestMethod.GET)
    public String testGet(@PathVariable("id") Integer id){
        System.out.println(id);
        return "show";
    }


    @RequestMapping(value = "/testOperate/{id}",method = RequestMethod.POST)
    public String testPost(@PathVariable("id")Integer id,String username){
            System.out.println(id);
            return "show";
    }


    /**
     * @ResponseBody
     *  标记你的方法的返回为json或者为字符串格式
     * @param id
     * @return
     */
    @RequestMapping(value = "/testOperate/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public String testPut(@PathVariable("id") Integer id){
        System.out.println(id);
        return "show";
    }


    @RequestMapping(value = "/testOperate/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public String testDel(@PathVariable("id") Integer id){
        System.out.println(id);
        return "show";
    }
}
