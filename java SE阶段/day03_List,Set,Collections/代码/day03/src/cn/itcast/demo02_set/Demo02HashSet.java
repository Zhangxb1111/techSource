package cn.itcast.demo02_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
    HashSet是Set接口下面最常用的实现类。
    满足Set接口的所有特点：
        1. 无序
        2. 无索引
        3. 不可重复

    对HashSet这个集合进行遍历
    遍历方式：
        1. 迭代器
        2. 增强for
 */
public class Demo02HashSet {
    public static void main(String[] args) {
        //创建一个HashSet集合
        Set<String> set = new HashSet<>();
        //添加元素
        set.add("大幂幂");
        set.add("小甜甜");
        set.add("大冰冰");
        //使用迭代器的方式进行遍历
        //获取到这个集合的迭代器
        Iterator<String> iterator = set.iterator();
        //使用循环遍历
        while(iterator.hasNext()) {
            //获取当前位置的元素
            System.out.println(iterator.next());
        }

        System.out.println("===================================");

        //使用增强for遍历
        for(String str : set) {
            System.out.println(str);
        }
    }
}
