package com.itheima.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class TestUser {
    SqlSessionFactory sessionFactory;

    @Before
    public void init() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mybatis.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 根据多个id查询
     */
    @Test
    public void testFindAll() {

    }

}
