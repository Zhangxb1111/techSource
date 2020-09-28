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

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findByUsername(String username) {
        return accountDao.findByUsername(username);
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public void save(Account account) {
        accountDao.save(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);
    }

    public long getTotalCount() {
        return accountDao.getTotalCount();
    }

    public void transfer(String fromUsername ,String toUsername, Double money){
        //获取转出的账户
        Account fromAccount = accountDao.findByUsername(fromUsername);

        //获取转入的账户
        Account toAccount = accountDao.findByUsername(toUsername);

        //开始转账
        fromAccount.setMoney(fromAccount.getMoney() - money);
        toAccount.setMoney(toAccount.getMoney() + money);

        accountDao.update(fromAccount);

        int i = 1/0;
        accountDao.update(toAccount);
    }
}
