package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatisAnn {

    SqlSessionFactory sessionFactory;

    @Before
    public void init() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mybatis.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    @Test
    public void testFindByQuery(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User u = new User();

        u.setUsername("王");

        List<User> userList = userDao.findByQuery(u);
        for (User user : userList) {
            System.out.println(user.getId());
            System.out.println(user.getUsername());
            for (Account account : user.getAccountList()) {
                System.out.println(account.getMoney());
            }
        }

        sqlSession.close();
    }


    @Test
    public void testFindAll(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        List<User> userList = userDao.findAll();


        for (User user : userList) {
            System.out.println(user.getId());
            System.out.println(user.getUsername());
            for (Account account : user.getAccountList()) {
                System.out.println(account.getMoney());
            }
        }

        sqlSession.close();
    }



}
