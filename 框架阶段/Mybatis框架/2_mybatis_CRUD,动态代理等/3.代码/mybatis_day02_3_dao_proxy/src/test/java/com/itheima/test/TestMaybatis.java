package com.itheima.test;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMaybatis {
    SqlSessionFactory sessionFactory = null;
    @Before
    public void init(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 代理： 在不修改源码的基础上对方法进行增强
     */
    @Test
    public void testFindAll(){
        //获取一个SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // 获取代理对象： 针对接口定义代理实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //访问代理对象中的方法
        List<User> userList = userMapper.findAll();

        for (User user : userList) {
            System.out.println(user.getUsername());
        }

        sqlSession.close();
    }

    @Test
    public void testFindById(){
        //获取一个SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // 获取代理对象： 针对接口定义代理实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //访问代理对象中的方法
        User user = userMapper.findById(1);
        System.out.println(user.getUsername());
        sqlSession.close();
    }
}
