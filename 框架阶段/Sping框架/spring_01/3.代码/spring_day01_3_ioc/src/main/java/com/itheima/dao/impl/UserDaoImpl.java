package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public void init(){
        System.out.println("初始化");
    }

    public void save() {
        System.out.println("保存用户");
    }

    public void destroy(){
        System.out.println("销毁");
    }
}
