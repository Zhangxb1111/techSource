package cn.itcast.demo04_objectstream;

import java.io.*;

/*
    ObjectOutputStream 叫做序列化流。 可以将java程序中的对象写入到文件中。

    构造方法：
        ObjectOutputStream​(OutputStream out)： 传递一个字节输出流对象。

    写对象方法：
        void writeObject​(Object obj)： 向文件中写入对象。

    使用步骤：
        1. 创建序列化流对象。
        2. 调用writeObject方法，向文件中写入一个指定的对象。
        3. 调用close方法，释放资源


    要写入到文件的类的对象，必须实现一个接口，这个接口叫做Serializable。
    这个接口叫做序列化接口。只有实现这个接口的类的对象，才具备序列化的作用

 */
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        //1. 创建序列化流对象。
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file03-obj.txt"));

        //2. 调用writeObject方法，向文件中写入一个指定的对象。
        Person p = new Person("小明", 8);
        oos.writeObject(p);

        //3. 调用close方法，释放资源
        oos.close();
    }
}
