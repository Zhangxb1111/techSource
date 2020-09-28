package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    /**
     *
     * 注解注入 :DI
     *  1. 不用提供set方法，构造方法
     *  2. @Autowired 注解即可
     *      默认的是：按照类型注入
     *      如果类型有多个，按照属性名默认名称查找bean对象
     *      @Qualifier:按照指定名称注入
     */
    @Autowired
//    @Qualifier("accountDao2")
//    AccountDao accountDao;

    /**
     * Resource: 默认按照名称注入
     *  如果没有指定名称，没有找到名称，会按照类型注入
     */
    @Resource
    AccountDao accountDao;


    public void show(){
        System.out.println("业务层的show方法");
        accountDao.show();
    }


}
