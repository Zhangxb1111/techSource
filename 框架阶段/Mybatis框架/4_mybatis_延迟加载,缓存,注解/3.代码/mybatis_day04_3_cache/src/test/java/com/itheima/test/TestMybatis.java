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

    /**
     * 一级缓存(默认存在的): 在连续两次执行统一sql语句时，第二次没有去数据库中查询
     *      在sql语句执行完成后，会使用sql语句作为key ，内容作为value，存储在缓存中
     *      
     *      session 级别的, 一级缓存在一个session中有效
     *
     *      一级缓存的清除问题： clearCache ：清除缓存
     *                          执行了commit 方法，也会清除缓存
     */
    @Test
    public void testFindAll1(){
        SqlSession sqlSession = sessionFactory.openSession();

        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<Account> accountList = accountDao.findAll();

        for (Account account : accountList) {
            System.out.println(account.getMoney());
        }
        //清除缓存
//        sqlSession.clearCache();

        sqlSession.commit();


        List<Account> accountList1 = accountDao.findAll();

        for (Account account : accountList1) {
            System.out.println(account.getMoney());
        }

        sqlSession.close();

    }

    /**
     * 二级缓存:默认是开启
     *      使用二级缓存：必须在配置文件中 配置  <cache/>
     *      应用级别的缓存：使用 key, namespace.findAll   ---- value:对象
     *          在执行某namespace下的查询方法时，存储到缓存中
     *          在执行某namespace下的增删改方法是，会清空此namespace的缓存
     *  注意：二级缓存的pojo对象必须序列化 Serializable 接口
     */
    @Test
    public void testFindAll() {
        SqlSession sqlSession = sessionFactory.openSession();

        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

        List<Account> accountList = accountDao.findAll();

        for (Account account : accountList) {
            System.out.println(account.getMoney());
        }
        sqlSession.close();


        SqlSession sqlSession1 = sessionFactory.openSession();

        AccountDao accountDao1 = sqlSession1.getMapper(AccountDao.class);

        List<Account> accountList1 = accountDao1.findAll();

        for (Account account : accountList1) {
            System.out.println(account.getMoney());
        }
        sqlSession1.close();


    }
}
