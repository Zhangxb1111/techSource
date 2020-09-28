package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;

import java.util.List;

public interface AccountDao {

    /**
     * 查询全部的账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 查询全部的账户(包含用户信息)
     * @return
     */
    public List<AccountUser> findAccountUser();
}
