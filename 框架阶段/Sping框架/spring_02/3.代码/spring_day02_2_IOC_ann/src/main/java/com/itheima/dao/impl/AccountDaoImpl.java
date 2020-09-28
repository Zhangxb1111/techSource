package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import org.springframework.stereotype.Repository;

// <bean id="accountDao" class="com.itheima.dao.impl.AccountDaoImpl"></bean>
// component: 创建bean对象
    //values ：对象创建的一个名称
// component:衍生了三个注解
    // @Repository ：持久层使用
    // @Service: 业务层中使用
    // @Controller: 表现层中使用： springMVC
@Repository("accountDao2")
public class AccountDaoImpl implements AccountDao {
    public void show() {
        System.out.println("持久层中的show方法");
    }
}
