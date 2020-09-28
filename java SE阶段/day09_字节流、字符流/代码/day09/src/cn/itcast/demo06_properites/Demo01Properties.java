package cn.itcast.demo06_properites;

import java.util.Properties;
import java.util.Set;

/*
    Properties​ 其实就是一个双列集合

    特点：
        1. Properties是Map接口的实现类。 拥有Map接口的中所有的方法。
        2. Properties没有泛型，键和值都是String
        3. 这个集合支持对流的操作，可以从流冲获取键值对。

    构造方法：
        Properties​()：使用空参数构造创建一个对象

    其他方法：
        Object setProperty​(String key, String value)：向Properties中添加键值对.
        String getProperty​(String key)： 根据key获取value。
        （了解）Set<String> stringPropertyNames​()：获取存放key的集合。

        void load​(InputStream inStream)： 从文件中(流)读取键值对， 参数需要字节输入流
        void load​(Reader reader)： 从文件中(流)读取键值对， 参数需要字节输入流。
 */
public class Demo01Properties {
    public static void main(String[] args) {
        //创建一个Properties
        Properties p = new Properties();
        //调用setPropertiy方法，向文件中添加键值对
        p.setProperty("it001", "rose");
        p.setProperty("it002", "jack");
        p.setProperty("it003", "tony");
        //p.put("it004", "tom");
        System.out.println(p);

        //根据key获取对应的value
        //获取it002对应的value值
        System.out.println(p.getProperty("it002")); //jack
        System.out.println(p.getProperty("it005")); //null

        //Set<String> stringPropertyNames​()：获取存放key的集合
        Set<String> set = p.stringPropertyNames();
        System.out.println(set); //[it003, it002, it001]
    }
}
