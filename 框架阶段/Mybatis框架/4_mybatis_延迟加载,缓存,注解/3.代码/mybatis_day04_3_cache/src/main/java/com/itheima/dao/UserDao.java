package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findById(Integer id);
}
