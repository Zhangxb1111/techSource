package cn.itcast.demo03_反射练习;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo02Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //把配置文件中的数据读取到Properties集合中
        Properties p = new Properties();
        //InputStream in = new FileInputStream("src\\test.properties");
        //InputStream in = Demo02Test.class.getClassLoader().getResourceAsStream("test.properties");
        //Reader r = new FileReader("src\\test.properties");
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src\\test.properties"),"gbk");
        p.load(isr);

        //获取配置文件中的类名
        String className = p.getProperty("className");

        Class clazz = Class.forName(className);
        //创建对象
        Object obj = clazz.newInstance();

        String methodName = p.getProperty("methodName");
        //调用方法
        Method m = clazz.getMethod(methodName);

        //让这个方法去执行
        m.invoke(obj);
    }
}
