package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestMybatisAnn {

    SqlSessionFactory sessionFactory;

    @Before
    public void init() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mybatis.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 查询所有的账户
     */
    @Test
    public void testFindAllAccount(){
        SqlSession sqlSession = sessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<Account> accountList = accountDao.findAll();

        for (Account account : accountList) {
            System.out.println(account.getId());
            System.out.println(account.getMoney());
            System.out.println(account.getUser().getUsername());
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
        }

        sqlSession.close();
    }

    @Test
    public void testFindById(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

         User user = userDao.findById(1);
            System.out.println(user.getUsername());

        sqlSession.close();
    }

    @Test
    public void testSave(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setUsername("赵虎");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南开封");

        userDao.save(user);


        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testDel(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.delById(11);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setId(5);
        user.setUsername("王朝");
        user.setBirthday(new Date());
        user.setSex("男");
        user.setAddress("河南开封");

        userDao.update(user);


        sqlSession.commit();

        sqlSession.close();
    }

}
