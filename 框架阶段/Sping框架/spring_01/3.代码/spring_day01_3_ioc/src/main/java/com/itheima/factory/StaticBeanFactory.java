package com.itheima.factory;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

/**
 * 静态的工厂
 */
public class StaticBeanFactory {

    public static UserDao createUserDao(){

        return new UserDaoImpl();
    }

    public static UserService createUserService(){
        return new UserServiceImpl();
    }
}
