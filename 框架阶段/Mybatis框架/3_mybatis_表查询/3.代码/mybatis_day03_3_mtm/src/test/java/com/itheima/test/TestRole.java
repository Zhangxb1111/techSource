package com.itheima.test;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestRole {
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
        SqlSession sqlSession = sessionFactory.openSession();

        RoleDao roleDao = sqlSession.getMapper(RoleDao.class);

        List<Role> roleList = roleDao.findAll();

        for (Role role : roleList) {
            System.out.print(role.getRoleName()+"::");
            for (User user : role.getUserList()) {
                System.out.print(user.getUsername()+",");
            }
            System.out.println();
        }

        sqlSession.close();
    }

}
