package cn.itcast.demo01_map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    了解
    jdk9，在List接口，Set接口，Map接口中提供了静态的of方法，可以直接创建带有少量元素的集合。

    注意：
        1. 这个of方法是List，Set，以及Map接口的静态方法，它的实现类中并没有这个方法。
        2. 通过这个of方法创建出来的集合是不可修改的（比如不能往集合中添加元素）
 */
public class Demo07Map {
    public static void main(String[] args) {
        //List接口中的of方法
        List<String> list = List.of("aa", "bb", "cc");
        //打印list集合
        System.out.println(list);

        //Set接口中的of方法
        Set<String> set = Set.of("bbb", "ccc", "xxx", "zzz");
        System.out.println(set);

        //Map接口的of方法
        Map<String, String> map = Map.of("it001", "张三丰", "it002", "张无忌", "it003", "周姑娘");
        System.out.println(map);

    }
}
