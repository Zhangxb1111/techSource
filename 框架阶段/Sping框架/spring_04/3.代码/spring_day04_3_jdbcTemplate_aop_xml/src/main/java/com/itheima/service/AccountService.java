package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {

    /**
     * 转账
     * @param fromUsername
     * @param toUsername
     * @param money
     */
    public void transfer(String fromUsername ,String toUsername, Double money);
    /**
     * 查全部
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据用户名返回唯一张虎虎
     * @param username
     * @return
     */
    public Account findByUsername(String username);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 账户的保存
     * @param account
     */
    public void save(Account account);

    /**
     * 跟新账户
     * @param account
     */
    public void update(Account account);

    /**
     * 根据id删除
     * @param id
     */
    public void delete(Integer id);

    /**
     * 返回总的记录数
     * @return
     */
    public long getTotalCount();

}
