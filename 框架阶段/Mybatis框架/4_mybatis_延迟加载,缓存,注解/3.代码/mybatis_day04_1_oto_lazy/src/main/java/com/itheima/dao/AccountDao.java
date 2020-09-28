package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询全部账户
     * @return
     */
    public List<Account> findAll();
}
