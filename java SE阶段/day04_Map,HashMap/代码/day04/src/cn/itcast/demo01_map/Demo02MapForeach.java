package cn.itcast.demo01_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Map集合的遍历

    Map集合能够直接使用增强for或者迭代器吗？？ 不可以。

    Map集合遍历方式：
    我们可以先拿到Map集合中所有的key， 把所有的key放入到一个Set集合中，然后再遍历这个Set集合，拿到
    里面的每一个key，根据key获取value。

    方法：
    Set<K> keySet​()：可以获取Map集合中所有的key，并且把这些key放入到Set集合中返回

    具体遍历的步骤：
        1. 调用keySet方法，得到存放所有键的Set集合
        2. 遍历这个Set集合，拿到Set集合中的每一个键
        3. 得到键之后，调用map的get方法，根据key获取value。


 */
public class Demo02MapForeach {
    public static void main(String[] args) {
        //创建一个Map集合
        Map<String, String> map = new HashMap<>();
        //添加元素
        map.put("it001", "柳如是");
        map.put("it002", "柳下惠");
        map.put("it003", "柳宗元");

        //开始遍历。
        //1. 调用keySet方法，得到存放所有键的Set集合
        Set<String> set = map.keySet();
        //2. 遍历这个Set集合，拿到Set集合中的每一个键
        for(String key : set) {
            //3. 得到键之后，调用map的get方法，根据key获取value。
            String value = map.get(key);
            System.out.println(key + "--" + value);
        }
    }
}
