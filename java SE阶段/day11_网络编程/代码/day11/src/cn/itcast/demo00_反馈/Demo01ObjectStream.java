package cn.itcast.demo00_反馈;

import java.io.*;

/*
    能够使用反序列化流读取文件中的对象到程序中

    使用反序列化流从文件中读取的对象一定是要使用序列化流写进去的

    可以将文件写入到java程序中。
 */
public class Demo01ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //writeObject();
        readObject();
    }

    //读取对象
    public static void readObject() throws IOException, ClassNotFoundException {
        //创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aa.txt"));
        //调用readObject方法，读取对象
        Object obj = ois.readObject();

        Person p = (Person)obj;
        System.out.println(p.getName() + "--" + p.getAge());
        ois.close();
    }

    //写对象
    public static void writeObject() throws IOException {
        //创建一个序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aa.txt"));
        //调用writeObject方法，向文件中写入一个对象
        oos.writeObject(new Person("狗蛋", 12));
        //释放资源
        oos.close();
    }
}
