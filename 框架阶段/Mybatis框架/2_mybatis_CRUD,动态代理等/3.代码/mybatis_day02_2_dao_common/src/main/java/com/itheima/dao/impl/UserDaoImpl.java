package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    SqlSessionFactory sessionFactory;

    public UserDaoImpl(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> findAll() {
        SqlSession sqlSession = sessionFactory.openSession();
        List<User> userList = sqlSession.selectList("aaaaaaa.findAll");
        sqlSession.close();
        return userList;
    }

    public User findById(Integer id) {
        SqlSession sqlSession = sessionFactory.openSession();
        User user = sqlSession.selectOne("aaa.findById",id);
        sqlSession.close();
        return user;
    }

    public void save(User user) {

    }
}
