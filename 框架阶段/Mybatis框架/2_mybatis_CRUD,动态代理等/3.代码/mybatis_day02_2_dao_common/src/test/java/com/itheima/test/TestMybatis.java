package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    SqlSessionFactory sessionFactory;

    @Before
    public void init(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindAll(){
        UserDao userDao = new UserDaoImpl(sessionFactory);

        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
    }

    @Test
    public void testFindById(){
        UserDao userDao = new UserDaoImpl(sessionFactory);
        User user = userDao.findById(1);
        System.out.println(user.getUsername());
    }
}
