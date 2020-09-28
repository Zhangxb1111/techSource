package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * customer ;客户
 * custom：自定义
 */
public class TestMybatisCustomFrame {

    @Test
    public void test(){
        // 获取配置文件的输入流
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        // 通过构建者模式创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过SqlSessionFactory 创建SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // 执行sql语句
        List<User> list = sqlSession.selectList("com.itheima.mapper.UserMapper.findAll");

        for (User user : list) {
            System.out.println(user.getId());
            System.out.println(user.getUsername());
            System.out.println(user.getAddress());
        }

    }
}
