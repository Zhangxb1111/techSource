package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 查全部
     * @return
     */
    public List<User> findAll();


    /**
     * 保存
     * @param user
     */
    public void save(User user);


    /**
     * 根据条件查询
     * @param user
     * @return
     */
    public List<User> findByCondition(User user);

    /**
     * 根据多个id查询用户
     * @param ids
     * @return
     */
    List<User> findByIds(Integer[] ids);

    /**
     * 根据id删除多个用户
     * @param ids
     */
    void deleteByIds(List<Integer> ids);
}
