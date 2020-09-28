package cn.itheima.test;

import cn.itheima.entity.UserInfo;
import cn.itheima.tnb.core.SqlSession;
import cn.itheima.tnb.factory.SqlSessionFactory;
import cn.itheima.tnb.factory.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.List;

/**
 * 测试类
 */
public class M1Test4 {


    @Test
    public void test1(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.buider();
        SqlSession session = factory.openSession();
        try {
            List<UserInfo> list = session.selectList("cn.itheima.dao.UserDAO.findAllUsers");
            for (UserInfo userInfo : list) {
                System.out.println(userInfo.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
