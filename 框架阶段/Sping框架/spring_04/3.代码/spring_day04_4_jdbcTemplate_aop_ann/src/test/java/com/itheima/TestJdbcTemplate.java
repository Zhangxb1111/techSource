package com.itheima;


import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestJdbcTemplate {


    public void test(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean(AccountService.class);
    }

    @Autowired
    AccountServiceImpl accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("lulu","lulu",10000.);
    }

    @Test
    public void testFindAll(){
        List<Account> accountList = accountService.findAll();

        for (Account account : accountList) {
            System.out.println(account.getUsername());
        }
    }

    @Test
    public void testFindByUsername(){
        Account account = accountService.findByUsername("zhangsan");
        System.out.println(account.getUsername());
    }

    @Test
    public void testSaveAcount(){

        Account account = new Account();
        account.setUsername("lili");
        account.setMoney(1000.);
        accountService.save(account);
    }


    @Test
    public void testUpdateAcount(){

        Account account = new Account();
        account.setId(12);
        account.setUsername("lulu");
        account.setMoney(999999.);
        accountService.update(account);
    }




}
