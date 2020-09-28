package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
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
public class TestDao {

    @Autowired
    AccountDao accountDao;


    @Test
    public void test(){

        List<Account> accountList = accountDao.findAll();

        for (Account account : accountList) {
            System.out.println(account.getUsername());
        }
    }
}
