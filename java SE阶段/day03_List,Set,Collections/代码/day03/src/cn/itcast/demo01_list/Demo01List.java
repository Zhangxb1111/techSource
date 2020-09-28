package cn.itcast.demo01_list;

import java.util.ArrayList;
import java.util.List;

/*
    List接口是Collection下面的一个子接口。

    List接口有以下特点：
        1. 有序（有序不是顺序， 怎么存就怎么取）
        2. 有索引。
        3. 可以存放重复元素。

   list接口下面常见的实现类。 ArrayList，LinkedList
 */
public class Demo01List {
    public static void main(String[] args) {
        //创建一个List集合
        List<String> list = new ArrayList<>();

        //往集合中添加元素
        list.add("爱迪生");
        list.add("达尔文");
        list.add("达芬奇");

        //直接打印这个集合
        System.out.println("list:" + list); //[爱迪生, 达尔文, 达芬奇]

        //根据索引获取集合中的元素
        String value = list.get(1);
        System.out.println("value:" + value); //达尔文

        //往集合中添加一个达芬奇
        list.add("达芬奇");
        System.out.println("list:" + list); // [爱迪生, 达尔文, 达芬奇, 达芬奇]
    }
}
