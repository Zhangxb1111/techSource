package cn.itcast.demo01_map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/*
    （了解）
    LinkedHashMap是Map接口中的另一个实现类。

    内部除了有一个哈希表之外还有一个链表。

    链表的作用是保证有序。

 */
public class Demo05LinkedHashMap {
    public static void main(String[] args) {
        //创建集合
        Map<String, String> map = new LinkedHashMap<>();

        //调用put方法，向集合中添加元素
        map.put("it001", "牛顿");
        map.put("it002", "金士顿");
        map.put("it003", "华盛顿");

        //遍历Map集合
        //使用keySet的方式进行遍历

        Set<String> set = map.keySet();

        for(String key : set) {
            //根据key获取value
            String value = map.get(key);
            System.out.println(key + "-" + value);
        }
    }
}
