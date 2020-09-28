package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.factory.BeanFatory;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = (UserDao) BeanFatory.getBean("userDao");

    public void save() {
        userDao.save();
    }
}
