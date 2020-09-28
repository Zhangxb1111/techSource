package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Transactional 开启事务，默认是必须开启，如果没有事务，创建事务，默认隔离级别， 不是只读
 *      如果加到类，类中所有的方法，都生效
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AccountServiceImpl {

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
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void save(Account account) {
        accountDao.save(account);
    }
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void update(Account account) {
        accountDao.update(account);
    }
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void delete(Integer id) {
        accountDao.delete(id);
    }

    public long getTotalCount() {
        return accountDao.getTotalCount();
    }
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
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
