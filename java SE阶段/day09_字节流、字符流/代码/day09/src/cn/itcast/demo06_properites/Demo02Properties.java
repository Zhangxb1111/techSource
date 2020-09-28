package cn.itcast.demo06_properites;

import com.sun.jdi.Value;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
    使用Properties集合从文件中读取键值对。

    使用的方式：
        void load​(InputStream inStream)： 从文件中(流)读取键值对， 参数需要字节输入流
        void load​(Reader reader)： 从文件中(流)读取键值对， 参数需要字节输入流。


    步骤：
        1. 创建Properties集合。
        2. 创建一个输入流对象，并且绑定一个目的地。
        3. 调用Properties集合的load方法，就可以将文件中的键值对加载到Properties集合中。
        4. 打印Properties。

     注意：
        文件的要求：
            1. 文件一般以.properties结尾。 以这个结尾的一般我们成为配置文件。（软性规定）
            2. 文件中的内存必须按照下面的格式进行存储（硬性规定）
                key=value
                key=value
                key=value
 */
public class Demo02Properties {
    public static void main(String[] args) throws IOException {
        //1. 创建Properties集合
        Properties p = new Properties();
        //2. 创建一个输入流对象，并且绑定一个目的地。
        FileInputStream fis = new FileInputStream("config.properties");
        //3. 调用Properties集合的load方法，就可以将文件中的键值对加载到Properties集合中。
        p.load(fis);
        //4. 释放资源
        fis.close();

        //遍历
        Set<String> set = p.stringPropertyNames();
        for(String key : set) {
            System.out.println(key + "--" + p.getProperty(key));
        }
    }
}
