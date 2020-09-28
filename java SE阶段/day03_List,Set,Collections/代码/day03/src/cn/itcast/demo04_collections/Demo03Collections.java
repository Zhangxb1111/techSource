package cn.itcast.demo04_collections;

import java.util.ArrayList;
import java.util.Collections;

/*
    Collections中还有一个sort方法，可以根据比较器排序
    static void sort​(List list, Comparator c):
        参数list：是要排序的集合
        参数c： 是比较器， 好比一个法官。

    如果使用比较器排序，那么这个集合的泛型是不需要实现Comparable接口的。


    总结：
        一个类实现Comparable接口，表示这个类的对象本身就具备了排序的功能，这种排序叫做自己排序。


        另一种方式是比较器排序，如果对象本身并不具备自然排序的功能，那么可以找一个法官帮这些对象
        进行排序，这个法官就是比较器。

        重点掌握比较器。

 */
public class Demo03Collections {
    public static void main(String[] args) {
        //定义集合，保存
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("大幂幂", 18));
        list.add(new Student("金星", 16));
        list.add(new Student("凤姐", 20));

        //使用static void sort​(List list, Comparator c) 对集合进行排序。

        Collections.sort(list, new Rule());

        //打印
        System.out.println("list:" + list);

    }
}
