package cn.itcast.demo05_generic;

import java.util.ArrayList;

/*
    泛型的限定。对泛型通配符的范围进行限制。

    <? extends A>：表示泛型的类型只能是A类或者A类的子类。 上限，最高到A类。
    <? super A>： 表示泛型的类型只能是A类或者A类的父类。  下限，最低到A类。

    泛型的使用场景：
        一般用于后期的代码重构，代码的优化。
 */
public class Demo02Generic {
    public static void main(String[] args) {
        //创建一个集合
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("小苍同学", 12));
        list.add(new Student("小泽同学", 18));
        list.add(new Student("小波同学", 18));//波多尔斯基

        //调用方法，进行遍历
        printArrayList(list);

        ArrayList<Person> list2 = new ArrayList<>();
        printArrayList(list2);

        ArrayList<Object> list3 = new ArrayList<>();
        //printArrayList(list3);  报错，不合法。

        //method(list); 不可以，因为泛型是子类，此时只能是Person或者他的父类
        //method(list2);
        method(list3);
    }

    public static void method(ArrayList<? super Person> list) {// 参数泛型只能是Person或者Person的父类。

    }

    /*
        定义一个方法，用来对保存Person对象的集合进行遍历。
        也包含Person的子类对象。
     */
    public static void printArrayList(ArrayList<? extends Person> list) {//参数泛型只能是Person或者Person的子类。
        //遍历这个集合
        for (Person p : list) {
            System.out.println(p);
        }
    }
}
