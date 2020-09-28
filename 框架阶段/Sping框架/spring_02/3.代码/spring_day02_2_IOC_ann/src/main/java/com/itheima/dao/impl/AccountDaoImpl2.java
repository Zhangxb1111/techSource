package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.stereotype.Component;

@Component("accountDao")
public class AccountDaoImpl2 implements AccountDao {
    public void show() {
        System.out.println("账户的持久层第二个实现类");
    }
}
