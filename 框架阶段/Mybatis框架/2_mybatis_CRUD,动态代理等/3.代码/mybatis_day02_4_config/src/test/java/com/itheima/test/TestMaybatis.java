package com.itheima.test;

import com.itheima.domain.QueryVO;
import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            System.out.println(user.getId());
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
        System.out.println(user.getBirthday());
        sqlSession.close();
    }


    @Test
    public void testFindByPage(){
        //获取一个SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // 获取代理对象： 针对接口定义代理实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //创建查询对象
        QueryVO queryVO = new QueryVO();
        queryVO.setStartIndex(0);
        queryVO.setPageSize(2);
        // 创建查询对象中的User对象
        User user = new User();
        user.setUsername("王");
        // 把user对象传入到查询对象中
        queryVO.setUser(user);

        //访问代理对象中的方法
        List<User> userList= userMapper.findByPage(queryVO);

        for (User user1 : userList) {
            System.out.println(user1.getUsername());
        }
        sqlSession.close();
    }

    @Test
    public void testFindByMap(){
        //获取一个SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // 获取代理对象： 针对接口定义代理实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Map<String ,Object> map = new HashMap<>();
        map.put("username", "王");
        map.put("startIndex", 0);
        map.put("pageSize" , 3);

        //访问代理对象中的方法
        List<User> userList= userMapper.findByMap(map);

        for (User user1 : userList) {
            System.out.println(user1.getUsername());
        }
        sqlSession.close();
    }

    @Test
    public void testfindByManyQueryVo(){
        //获取一个SqlSession
        SqlSession sqlSession = sessionFactory.openSession();
        // 获取代理对象： 针对接口定义代理实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);



        //访问代理对象中的方法
        List<User> userList= userMapper.findByManyQueryVo("王", 3 , 0);

        for (User user1 : userList) {
            System.out.println(user1.getUsername());
        }
        sqlSession.close();
    }
}
