package com.itheima.controller;

import com.itheima.domain.SSM;
import com.itheima.service.SSMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ssm")
public class SSMController {

    @Autowired
    SSMService ssmService;

    @RequestMapping("/findById")
    public ModelAndView findById(Integer id){
        SSM ssm =  ssmService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ssm",ssm);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
