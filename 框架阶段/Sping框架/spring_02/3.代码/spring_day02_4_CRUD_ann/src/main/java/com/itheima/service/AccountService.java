package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {

    /**
     * 根据分页查询
     * @param pageSize
     * @param pageNum
     * @return
     */
    public List<Account> findByPage(Integer pageSize, Integer pageNum);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Account  findById(Integer id);

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
     * 根据id删除
     * @param id
     */
    public void delById(Integer id);

    /**
     * 查询总的记录数
     * @return
     */
    public int getTotalCount();
}
