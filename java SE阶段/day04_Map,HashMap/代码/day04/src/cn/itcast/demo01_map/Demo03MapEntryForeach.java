package cn.itcast.demo01_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Map集合的第二种方式（entrySet遍历）

    步骤：
        1. 获取到Map集合中所有的Entry对象，把这些Entry对象放入到一个set集合中
        2. 遍历这个Set集合，拿到里面的每一个Entry对象
        3. 调用Entry对象的方法，获取到这个Entry对象中的key和value。

    如何获取所有的Entry对象， 调用Map集合的entrySet方法：
        Set<Map.Entry<K,V>> entrySet​()：得到存放所有Entry对象的Set集合。

    如何获取到Entry对象中的key和value。 调用Entry对象的getKey和getValue就可以。
        K getKey​()：获取所有的key
        V getValue​() 获取所有的value

    两种遍历方式，推荐第一种(keySet)
 */
public class Demo03MapEntryForeach {
    public static void main(String[] args) {
        //创建Map集合
        Map<String, String> map = new HashMap<>();
        //调用put方法，向Map集合中添加键值对
        map.put("it001", "林冲");
        map.put("it002", "金莲");
        map.put("it003", "西门大官人");

        //使用entrySet的方式进行遍历。
        //1. 获取到Map集合中所有的Entry对象，把这些Entry对象放入到一个set集合中
        Set<Map.Entry<String, String>> set = map.entrySet();

        //2. 遍历Set集合，拿到里面的每个Entry对象
        for(Map.Entry<String, String> entry : set) {
            //3. 调用Entry对象的方法，获取到这个Entry对象中的key和value。
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "--" + value);
        }
    }
}
