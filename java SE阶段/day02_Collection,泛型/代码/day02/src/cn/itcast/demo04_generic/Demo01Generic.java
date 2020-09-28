package cn.itcast.demo04_generic;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.ArrayList;

/*
    泛型：就是一种不确定的数据类型。

    比如：ArrayList<E> E就是泛型。 这种不确定的数据类型需要在使用这个类的时候才能够确定出来。

    泛型可以省略，如果省略，默认泛型是Object类型。

    泛型的好处：
        1. 省略了强转的代码。
        2. 可以把运行时的问题提前到编译时期。

 */
public class Demo01Generic {
    public static void main(String[] args) {
        //创建集合，不给出泛型
        ArrayList listOne = new ArrayList();
        listOne.add("hello");
        listOne.add("world");
        listOne.add("java");
        //listOne.add(100); 运行时期保存

        //进行遍历，打印每个字符串的长度
        for(Object obj : listOne) {
            //把obj向下转型成String
            String str = (String)obj;
            System.out.println(str.length());
        }
        System.out.println("=========================");

        //创建集合给出泛型
        ArrayList<String> list = new ArrayList<>();
        //往集合中添加元素
        list.add("hello");
        list.add("world");
        list.add("php");
        //list.add(100); 编译时期就报错了

        //使用增强for遍历，打印每个字符串的长度
        for (String str : list) {
            System.out.println(str.length());
        }

    }
}
