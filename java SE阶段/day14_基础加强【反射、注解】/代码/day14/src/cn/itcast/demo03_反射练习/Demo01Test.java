package cn.itcast.demo03_反射练习;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

/*
    创建学生对象，并且通过读取配置文件的方式给学生对象的属性赋值

    步骤：
        1. 创建一个Student对象。
        2. 使用Properties读取配置文件，将配置文件中的键值对放入到Properties集合中。
        3. 遍历Properties集合，拿到里面的每一个键值对，并且根据键名给对应的属性赋值。
 */
public class Demo01Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException {
        //获取到Student的Class对象
        Class clazz = Class.forName("cn.itcast.demo03_反射练习.Student");

        //通过这个类的Class对象创建一个Student对象
        Object obj = clazz.newInstance();

        //使用Properties读取配置文件，将配置文件中的键值对放入到Properties集合中。
        Properties p = new Properties();
        InputStream in = new FileInputStream("src\\config.properties");
        //一般都是把文件放到类路径下，我们可以把这个文件放到src下，当对源代码进行编译，那么在类路径下也会出现一个这样的文件
        //如果获取类路径下的东西
        //在idea里面类路径是 out\production\day14
        //InputStream in = Demo01Test.class.getClassLoader().getResourceAsStream("config.properties");

        //调用p的load方法，就可以把配置文件中的键值对加载到Properties集合中
        p.load(in);

        //遍历Properties集合，拿到里面的每一个键值对，并且根据键名给对应的属性赋值。
        Set<String> set = p.stringPropertyNames();
        for(String key : set) {
            //key就是属性名， value是这个属性对应的属性值。
            //根据key获取value
            String value = p.getProperty(key);

            //获取到的set方法的方法名
            //age -> setAge   name -> setName
            String setMethodStr = "set" + key.substring(0, 1).toUpperCase() + key.substring(1);

            //获取Student类中的set方法
            Method m = clazz.getMethod(setMethodStr, String.class);

            //让这个setXXX方法去执行，给属性赋值
            m.invoke(obj, value);
        }

        System.out.println(p);
    }
}
