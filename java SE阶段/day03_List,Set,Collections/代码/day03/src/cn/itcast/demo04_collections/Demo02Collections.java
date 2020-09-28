package cn.itcast.demo04_collections;

import java.util.ArrayList;
import java.util.Collections;

/*
    Collections 中有一个方法叫做sort可以对集合中的内容进行排序
    static void sort​(List list)： 对集合中的内容进行排序

    要使用这个sort方法进行排序的集合，里面的泛型必须实现Comparable接口

    实现这个接口的对象才具备排序的功能， 这种排序自然排序。

    口诀：
    升序就是我减他，降续就是他减我

 */
public class Demo02Collections {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("cc");
        list1.add("bb");
        //调用sort方法，对list1进行排序
        Collections.sort(list1);
        //打印结果
        System.out.println("list1:" + list1);

        //定义集合保存数字
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(20);
        list2.add(10);
        list2.add(30);
        //进行排序
        Collections.sort(list2);
        //打印结果
        System.out.println("list2:" + list2);

        //定义集合，保存Person
        ArrayList<Person> list3 = new ArrayList<>();
        list3.add(new Person("大幂幂", 20));
        list3.add(new Person("小甜甜", 10));
        list3.add(new Person("大冰冰", 30));

        Collections.sort(list3);

        System.out.println("list3:" + list3);
    }
}
