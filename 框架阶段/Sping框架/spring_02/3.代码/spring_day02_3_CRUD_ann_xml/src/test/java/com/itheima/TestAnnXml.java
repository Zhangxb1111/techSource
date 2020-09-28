package com.itheima;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @RunWith(SpringJUnit4ClassRunner.class)  : 代替junit的测试注解
  @ContextConfiguration({"classpath:applicationContext.xml"}): 指定配置文件的问题

 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestAnnXml {


    @Autowired
    AccountService accountService ;

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

        account.setUsername("mahan");
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
