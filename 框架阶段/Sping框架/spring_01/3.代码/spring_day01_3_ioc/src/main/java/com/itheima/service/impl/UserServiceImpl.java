package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao ;

    public void save() {

        userDao.save();
    }
}
