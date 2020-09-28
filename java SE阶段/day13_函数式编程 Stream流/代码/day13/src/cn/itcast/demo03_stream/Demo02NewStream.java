package cn.itcast.demo03_stream;

import java.util.ArrayList;
import java.util.List;

/*
    Stream流初体验

    1. 获取所有姓张的
    2. 基于上一步，获取所有名字是三个字的人。
    3. 遍历打印最终的结果。
 */
public class Demo02NewStream {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
    }
}
