package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountDao")
    AccountDao accountDao;

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
