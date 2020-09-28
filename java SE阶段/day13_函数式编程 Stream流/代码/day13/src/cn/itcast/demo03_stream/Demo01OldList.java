package cn.itcast.demo03_stream;

import java.util.ArrayList;
import java.util.List;

/*
    使用传统方式遍历集合

    1. 获取所有姓张的
    2. 基于上一步，获取所有名字是三个字的人。
    3. 遍历打印最终的结果。


 */
public class Demo01OldList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //1. 获取所有姓张的
        List<String> zhangList = new ArrayList<>();
        //遍历list集合，拿到每一个元素，判断如果以张开头，那么就添加到zhangList集合
        for(String str : list) {
            if(str.startsWith("张")) {
                zhangList.add(str);
            }
        }

        //2. 基于上一步，获取所有名字是三个字的人。
        List<String> threeList = new ArrayList<>();
        //遍历zhangList，拿到里面的每一个元素，判断这个元素的长度，如果是3，就添加到threeList中。
        for(String str : zhangList) {
            if(str.length() == 3) {
                threeList.add(str);
            }
        }

        //3. 遍历打印最终的结果。
        for(String str : threeList) {
            System.out.println(str);
        }
    }
}
