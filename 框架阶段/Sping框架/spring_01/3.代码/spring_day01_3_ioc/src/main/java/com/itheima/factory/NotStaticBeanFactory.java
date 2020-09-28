package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

/**
 * 非静态的工厂
 */
public class NotStaticBeanFactory {

    public UserDao createUserDao(){
        return new UserDaoImpl();
    }

    public UserService createUserService(){
        return new UserServiceImpl();
    }
}
