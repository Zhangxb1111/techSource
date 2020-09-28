package com.itheima;

import com.itheima.prxoy.AccountServiceProxy;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAccountCRUD {

    @Autowired
    AccountServiceProxy accountServiceProxy;


    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Test
    public void transfer(){
        //被代理对象的创建,不能使用手动new的方式，因为自己new，springioc容器不会为你自动注入属性
//      AccountServiceImpl accountService = new AccountServiceImpl();

        //获取代理对象
        AccountServiceImpl proxyClass = accountServiceProxy.getProxyClass(accountServiceImpl);
//        //调用代理的方法
        proxyClass.transfer("zhangsan","maliu",100.0);
    }
}
