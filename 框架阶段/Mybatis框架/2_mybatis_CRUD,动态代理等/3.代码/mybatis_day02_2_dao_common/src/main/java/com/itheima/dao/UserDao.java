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
     * 根据id查询
     * @param id
     * @return
     */
    public User findById(Integer id);


    /**
     * 保存用户
     * @param user
     */
    public void save(User user);
}
