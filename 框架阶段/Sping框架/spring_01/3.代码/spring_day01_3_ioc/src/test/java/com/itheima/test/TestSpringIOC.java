package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringIOC {

    @Test
    public void test(){

        //读取配置文件,创建spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //从spring容器中读取对象
//        Object obj = ac.getBean("userDao");
//        System.out.println(obj);
        //从spring容器中读取对象
        //根据配置的id命名获取
        UserService userService = (UserService) ac.getBean("userService");
////        System.out.println(obj1);
//
        userService.save();

        //在spring容器创建对象后，会判断是否是你需要的类型
        UserDao userDao = ac.getBean("userDao", UserDao.class);

    }


    /**
     * 测试容器对象的细节问题
     */
    @Test
    public void testFactory(){
        // 在加载容器时直接创建对象(单例模式的对象),存储在容器中，需要时直接用即可
        // 常用的
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //记载配置文件，创建容器，不会创建对象，用时创建创建
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
//
//        Object userDao = beanFactory.getBean("userDao");


    }

    /**
     * 测试单例和多例
     */
    @Test
    public void testScope(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        Object userDao1 = ac.getBean("userDao");
//        System.out.println(userDao1);
        Object userDao2 = ac.getBean("userDao");
//        System.out.println(userDao2);
        //关闭容器时，会销毁单例模式的对象
        //多例模式创建的对象需要java虚拟机自动回收
        ac.close();
    }

    /**
     * 使用静态的工厂创建对象
     */
    @Test
    public void testStaticFactory(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        UserDao userDao = (UserDao) ac.getBean("userDao-factory");
        System.out.println(userDao);

    }

    /**
     * 使用非静态的工厂创建对象
     */
    @Test
    public void testNotStaticFactory(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        UserDao userDao = (UserDao) ac.getBean("userDao-not-static-factory");
        System.out.println(userDao);

    }
}
