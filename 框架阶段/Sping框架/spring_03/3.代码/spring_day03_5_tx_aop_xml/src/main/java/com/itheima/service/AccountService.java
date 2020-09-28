package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {

    public void transfer(String fromUser, String toUser, Double money);

    public List<Account> findAll();

    public Account findByUsername(String username);

    public List<Account> findByPage(Integer pageNum, Integer pageSize);

    public Account findById(Integer id);

    public void save(Account account);

    public void update(Account account);

    public void del(Integer id);

    public int getTotalCount();
}
