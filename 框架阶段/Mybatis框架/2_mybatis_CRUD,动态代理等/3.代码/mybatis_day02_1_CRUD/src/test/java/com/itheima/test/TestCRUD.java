package com.itheima.test;

import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestCRUD {

    @Test
    public void testFindAll(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建一个回话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取一个回话对象
        SqlSession sqlSession = sessionFactory.openSession();

        List<User> userList = sqlSession.selectList("com.itheima.mapper.UserMapper.findAll");

        for (User user : userList) {
            System.out.println(user.getUsername());
        }

        sqlSession.close();
    }

    /**
     * selectList: 查询返回多行或者一行结果
     * selectOne： 查询返回一行结果
     */
    @Test
    public void testFindById(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建一个回话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取一个回话对象
        SqlSession sqlSession = sessionFactory.openSession();

        User user = sqlSession.selectOne("com.itheima.mapper.UserMapper.findById", 1);
        System.out.println(user.getUsername());
        sqlSession.close();
    }

    @Test
    public void testSave(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建一个回话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取一个回话对象
        SqlSession sqlSession = sessionFactory.openSession();
        //创建user对象
        User user = new User();
        user.setUsername("老王");
        user.setAddress("北京市海淀区");
        user.setBirthday(new Date());
        user.setSex("男");


        //执行sql语句
        sqlSession.insert("com.itheima.mapper.UserMapper.save", user);

        System.out.println("id:"+user.getId());

        // 执行提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建一个回话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取一个回话对象
        SqlSession sqlSession = sessionFactory.openSession();
        //创建user对象
        User user = new User();
        user.setId(4);
        user.setUsername("王五");
        user.setAddress("北京市海淀区");
        user.setBirthday(new Date());
        user.setSex("女");
        //执行sql语句
        sqlSession.update("com.itheima.mapper.UserMapper.update", user);

        // 执行提交
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void testDelete(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建一个回话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取一个回话对象
        SqlSession sqlSession = sessionFactory.openSession();

        //执行删除
        sqlSession.delete("com.itheima.mapper.UserMapper.delete",4);
        // 执行提交
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindByUsername(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        //创建一个回话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取一个回话对象
        SqlSession sqlSession = sessionFactory.openSession();


        List<User> userList = sqlSession.selectList("com.itheima.mapper.UserMapper.findByUsername", "王");
        for (User user : userList) {
            System.out.println(user.getUsername());
        }
        sqlSession.close();
    }
}
