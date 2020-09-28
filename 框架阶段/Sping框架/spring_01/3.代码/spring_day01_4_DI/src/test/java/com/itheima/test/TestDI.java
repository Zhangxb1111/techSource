package com.itheima.test;

import com.itheima.domain.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {

    @Test
    public void testAttr(){
        //创建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = (User) ac.getBean("user");


//        System.out.println(user.getUsername());
//        System.out.println(user.getId());
//        System.out.println(user.getBirthday());

        user.print();
    }
}
