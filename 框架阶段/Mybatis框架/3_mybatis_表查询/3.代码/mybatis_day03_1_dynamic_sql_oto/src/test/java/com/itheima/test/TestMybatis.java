package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMybatis {
    SqlSessionFactory sessionFactory;
    @Before
    public void init(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mybatis.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public void test(){
        Integer[] ids = new Integer[]{1,2,5};

        for (Integer i: ids  ) {
            System.out.println(i);
        }
    }

    /**
     * 根据多个id查询
     */
    @Test
    public  void findByIds(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        Integer[] ids = new Integer[]{1,2,5};

        List<User> userList = userDao.findByIds(ids);
        for (User user : userList) {
            System.out.println(user.getUsername());
        }

        sqlSession.close();
    }

    /**
     * 根据id删除多个用户
     */
    @Test
    public void testDeleteByids(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(7);
        ids.add(8);
        ids.add(9);
        userDao.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindByCondition(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setUsername("张");
        user.setSex("男");

        List<User> userList = userDao.findByCondition(user);

        for (User u : userList) {
            System.out.println(u.getUsername());
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
    public void testSaveNotAutoCommit(){
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setUsername("张龙");
        user.setAddress("北京市昌平区");
        user.setBirthday(new Date());
        user.setSex("男");

        userDao.save(user);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void testSaveAutoCommit(){
        //openSession(true) 获取一个可以自动提交的sqlSession
        // 默认的是openSession(false)
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setUsername("张龙");
        user.setAddress("北京市昌平区");
        user.setBirthday(new Date());
        user.setSex("男");

        userDao.save(user);

        //sqlSession.commit();

        sqlSession.close();
    }
}
