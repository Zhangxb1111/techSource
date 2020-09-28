package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public Account findByUsername(String username) {
        return null;
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public void del(Integer id) {
        accountDao.del(id);
    }

    @Override
    public void transfer(String fromUsername, String toUsername, Double money) {
//        要转出的账户
        Account fromAccount = accountDao.findByUsername(fromUsername);
//        要转入的账户
        Account toAccount = accountDao.findByUsername(toUsername);

        //开始转账
        fromAccount.setMoney(fromAccount.getMoney() - money);
        toAccount.setMoney(toAccount.getMoney() + money);
        //持久化到数据库
        accountDao.update(fromAccount);
        accountDao.update(toAccount);

    }
}
