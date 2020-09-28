package cn.itcast.demo04_objectstream;

import java.io.*;
import java.util.ArrayList;

/*
    练习
    1. 将存有多个自定义对象的集合序列化操作，保存到 list.txt 文件中。
    2. 反序列化 list.txt ，并遍历集合，打印对象信息

    思路：
        1. 创建集合，并且添加多个Person对象。
        2. 序列化流对象
        3. 将集合写入到文件。
        4. 创建反序列化流
        5. 把文件中的集合对象读取出来。

 */
public class Demo05Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1. 创建集合，并且添加多个Person对象。
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("刘备", 18));
        list.add(new Person("关羽", 20));
        list.add(new Person("张飞", 22));

        //2. 序列化流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file06-obj.txt"));

        //3. 将集合写入到文件。
        oos.writeObject(list);

        oos.close();

        //4. 创建反序列化流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file06-obj.txt"));

        //5. 把集合对象从文件读取出来
        Object obj = ois.readObject();

        //强转成集合
        ArrayList<Person> list2 = (ArrayList<Person>)obj;
        //遍历集合
        for(Person p : list2) {
            System.out.println(p.getName() + "--" + p.getAge());
        }
    }
}
