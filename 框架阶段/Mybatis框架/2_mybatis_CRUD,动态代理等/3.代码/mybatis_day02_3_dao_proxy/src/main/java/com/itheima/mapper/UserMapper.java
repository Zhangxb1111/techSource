package com.itheima.mapper;

import com.itheima.domain.User;

import java.util.List;

public interface UserMapper {

    /**
     * 查全部
     * @return
     */
    public List<User> findAll();

    /**
     * 根据id查询
     * @return
     */
    public User findById(Integer id);
}
