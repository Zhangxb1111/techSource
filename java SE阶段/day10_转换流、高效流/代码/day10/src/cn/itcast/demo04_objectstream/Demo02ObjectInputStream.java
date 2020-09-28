package cn.itcast.demo04_objectstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*
     ObjectInputStream是反序列化流，可以将文件中的对象读取到java程序中。

     构造方法：
        ObjectInputStream​(InputStream in)： 传递一个字节输入流


     读取对象的方法
        Object readObject​()： 从文件中读取对象并返回


     如果读取的时候，这个类不存在，那么就会抛出ClassNotFountException
 */
public class Demo02ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建一个ObjectInputStream对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file03-obj.txt"));

        //调用readObject方法，从文件中读取对象
        Object obj = ois.readObject();

        Person p = (Person)obj;

        System.out.println(p.getName() + "-" + p.getAge());

        //释放资源
        ois.close();

    }
}
