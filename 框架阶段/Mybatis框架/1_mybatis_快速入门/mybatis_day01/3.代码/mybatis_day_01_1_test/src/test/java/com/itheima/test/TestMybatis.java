package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void test(){
        InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();

        List<User> list = sqlSession.selectList("com.itheima.mapper.UserMapper.findAll");
        for (User user : list) {
            System.out.println(user.getId());
            System.out.println(user.getUsername());
        }
    }
}
