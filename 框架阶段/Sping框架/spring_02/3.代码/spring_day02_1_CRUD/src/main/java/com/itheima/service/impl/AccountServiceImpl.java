package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findByPage(Integer pageSize, Integer pageNum) {
        return accountDao.findByPage(pageSize,pageNum);
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

    public void delById(Integer id) {
        accountDao.delById(id);
    }

    public int getTotalCount() {
        return accountDao.getTotalCount();
    }
}
