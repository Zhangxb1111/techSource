package cn.itcast.demo04_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
    Collections是操作集合的工具类，里面有一些方法，可以对集合进行操作。


    static boolean addAll​(Collection c, T... elements)： 往集合中批量添加元素。
        参数c：表示往哪个集合中添加元素
        参数elements： 是可变参数，可以写任意个，表示要把这些元素添加到集合中。

    static void shuffle​(List list)： 打乱顺序。

    static void sort​(List list)： 排序。
    static void sort​(List list, Comparator c) 排序
 */
public class Demo01Collections {
    public static void main(String[] args) {
        //创建一个集合
        ArrayList<String> list = new ArrayList<>();
        //添加元素
//        list.add("hello");
//        list.add("world");
//        list.add("java");
//        list.add("php");
//        list.add("python");

        //static boolean addAll​(Collection c, T... elements)： 往集合中批量添加元素。
        Collections.addAll(list, "hello", "world", "java", "php", "python");

        //static void shuffle​(List list)： 打乱顺序。
        Collections.shuffle(list);
        //打印
        System.out.println(list);
    }
}
