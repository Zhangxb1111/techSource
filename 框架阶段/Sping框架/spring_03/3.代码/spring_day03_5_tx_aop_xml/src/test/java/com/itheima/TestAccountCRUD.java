package com.itheima;

import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestAccountCRUD {

    @Autowired
    AccountService accountService;


    @Test
    public void transfer(){
        accountService.transfer("zhangsan","maliu",100.0);
    }
}
