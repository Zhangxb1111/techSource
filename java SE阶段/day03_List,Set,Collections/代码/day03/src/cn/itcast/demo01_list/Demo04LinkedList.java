package cn.itcast.demo01_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    LinkedList是List接口的另一个实现类。

    内部是一个双向链表。
    特点： 查询慢，增删快。


 */
public class Demo04LinkedList {
    public static void main(String[] args) {
        //创建一个LinkedList集合
        List<String> list = new LinkedList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(list);
    }
}
