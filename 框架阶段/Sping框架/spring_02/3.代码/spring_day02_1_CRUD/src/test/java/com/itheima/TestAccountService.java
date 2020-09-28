package com.itheima;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAccountService {
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    AccountService accountService = ac.getBean("accountService", AccountService.class);

    @Test
    public void testFindByPage(){


        List<Account> accountList = accountService.findByPage(3, 1);

        for (Account account : accountList) {
            System.out.println(account.getUsername());
        }
    }

    @Test
    public void testFindById(){


        Account account = accountService.findById(1);

        System.out.println(account.getUsername());
    }

    @Test
    public void testSave(){

        Account account = new Account();

        account.setUsername("wangchao");
        account.setMoney(4400.);

        accountService.save(account);
    }


    @Test
    public void testUpdate(){

        Account account = new Account();
        account.setId(2);
        account.setUsername("mahan");
        account.setMoney(4400.);

        accountService.update(account);
    }

    @Test
    public void testDel(){

        accountService.delById(3);
    }

    @Test
    public void testGetTotalCount(){
        int count = accountService.getTotalCount();
        System.out.println(count);
    }



}
