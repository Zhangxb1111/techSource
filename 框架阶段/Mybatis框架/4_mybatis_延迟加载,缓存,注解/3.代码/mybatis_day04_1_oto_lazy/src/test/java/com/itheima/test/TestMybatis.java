package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    SqlSessionFactory sessionFactory;

    @Before
    public void init() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mybatis.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindAll(){
        SqlSession sqlSession = sessionFactory.openSession();

        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<Account> accountList = accountDao.findAll();

        for (Account account : accountList) {
            System.out.println(account.getMoney());
            System.out.println(account.getUser().getUsername());
        }

        sqlSession.close();

    }
}
