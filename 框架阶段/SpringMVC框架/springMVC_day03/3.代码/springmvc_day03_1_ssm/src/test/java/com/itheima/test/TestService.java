package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// 替换junit的运行器
@RunWith(SpringJUnit4ClassRunner.class)
//指定配置文件的路径
@ContextConfiguration("classpath:applicationContext.xml")
public class TestService {
    @Autowired
    AccountService accountService;

    @Test
    public void test(){
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account.getUsername());
        }
    }


    @Test
    public void testTransfer(){
        accountService.transfer("zhangsan","mahan", 1.);
    }
}
