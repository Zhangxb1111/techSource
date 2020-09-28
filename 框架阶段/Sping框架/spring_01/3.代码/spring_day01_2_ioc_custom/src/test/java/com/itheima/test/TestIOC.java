package com.itheima.test;

import com.itheima.factory.BeanFatory;
import com.itheima.service.UserService;
import org.junit.Test;

public class TestIOC {

    @Test
    public void test(){
        UserService userService = (UserService) BeanFatory.getBean("userService");
        userService.save();
    }

    @Test
    public void testIOCCustom(){
        Object obj = BeanFatory.getBean("userDao");
        System.out.println(obj);
    }
}
