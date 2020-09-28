package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {

    /**
     * 查询全部
     * @return
     */
    public List<Account> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Account findById(Integer id);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    public Account findByUsername(String username);

    /**
     * 保存账户
     * @param account
     */
    public void save(Account account);

    /**
     * 更新账户
     * @param account
     */
    public void update(Account account);

    /**
     * 删除账户
     * @param id
     */
    public void del(Integer id);

    /**
     * 转账业务：测试事务问题
     * @param fromUsername
     * @param toUsername
     * @param money
     */
    public void transfer(String fromUsername ,String toUsername,Double money);
}
