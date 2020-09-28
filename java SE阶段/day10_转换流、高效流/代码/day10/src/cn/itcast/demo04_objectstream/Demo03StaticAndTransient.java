package cn.itcast.demo04_objectstream;

import java.io.*;
/*
    static修饰的成员变量不能被序列化。

    如果想要让一个成员变量不会被序列化，同时也不想使用static关键字，那么可以使用transient关键字

    transient关键字表示瞬态，不会被序列化
 */
public class Demo03StaticAndTransient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        readObject();
    }

    //定义方法，将文件中的Person对象读取到Java程序中
    public static void readObject() throws IOException, ClassNotFoundException {
        //创建ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file04-obj.txt"));
        //调用readObject方法进行读取
        Object obj = ois.readObject();

        Person p = (Person)obj;
        System.out.println(p.getName() + "-" + p.getAge());
    }


    //定义方法，将一个Person对象写入到文件中
    public static void writeObject() throws IOException {
        //创建一个ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file04-obj.txt"));

        //调用writeObject方法，向文件中写入对象
        oos.writeObject(new Person("八神庵", 18));

        //释放资源
        oos.close();
    }
}
