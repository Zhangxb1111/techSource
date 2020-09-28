package cn.itcast.demo04_objectstream;

import java.io.*;

public class Demo04VersionUId {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        readObject();
    }

    //从文件中读取对象
    public static void readObject() throws IOException, ClassNotFoundException {
        //创建反序列化流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file05-obj.txt"));
        //调用readObject方法读取对象
        Object obj = ois.readObject();

        Person p = (Person)obj;
        System.out.println(p.getName() + "--" + p.getAge());

    }

    //向文件中写入一个对象
    public static void writeObject() throws IOException {
        //创建序列化流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file05-obj.txt"));

        //调用writeObject方法，向文件中写对象
        oos.writeObject(new Person("李白", 20));

        //释放资源
        oos.close();
    }
}
