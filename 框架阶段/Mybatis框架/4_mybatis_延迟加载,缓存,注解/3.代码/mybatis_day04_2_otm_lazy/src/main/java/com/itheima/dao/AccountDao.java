package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 根据userid查询账户信息
     * @param userId
     * @return
     */
    public List<Account> findByUserId(Integer userId);
}
