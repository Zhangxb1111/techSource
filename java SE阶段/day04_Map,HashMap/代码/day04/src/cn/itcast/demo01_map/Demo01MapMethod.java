package cn.itcast.demo01_map;

import java.util.HashMap;
import java.util.Map;

/*
    Map集合的常用方法。

    Map集合是一个双列集合，里面的每个元素都是一个键值对。
    Map<K,V> 有两个泛型， K 表示Map集合中键的类型。 V 表示Map集合中值的数据类型。

    常用方法：
        (重要)V put​(K key, V value)： 向Map集合中添加键值对。
        (重要)V get​(Object key)： 根据key获取到value的值。
        V remove​(Object key)：根据key直接删除整个的键值对。 返回被删除的value

    Map接口最常用的实现类是HashMap
 */
public class Demo01MapMethod {
    public static void main(String[] args) {
        //创建一个Map集合，key是数字，value是字符串
        Map<Integer, String> map = new HashMap<>();
        //向Map集合中添加键值对
        map.put(100, "刘德华");
        map.put(200, "张学友");
        map.put(300, "郭富城");
        //打印map集合
        System.out.println("map:" + map);

        //获取key为100的元素对应的值
        System.out.println(map.get(100)); //刘德华
        //如果获取的时候这个键值对不存在，结果就是null
        System.out.println(map.get(10000));//null

        //删除key为200的键值对
        String value = map.remove(200);
        System.out.println("value:" + value); // 张学友
        System.out.println("map:" + map); // {100=刘德华, 300=郭富城}


        System.out.println("===========================================");



        //创建Map集合，key是String，value也是字符串
        Map<String, String> map2 = new HashMap<>();
        //往集合中添加键值对
        map2.put("it001", "渣渣辉");
        map2.put("it002", "古天乐");
        map2.put("it003", "陈小春");
        //如果使用put方法，向map集合中添加键值对，如果这个key已经存在，就会把原来的覆盖掉。
        map2.put("it003", "林子聪");

        //打印map2集合
        System.out.println("map2:" + map2);

        //了解
        //如果调用put方法，没有产生覆盖的效果，那么返回值就是null。
        System.out.println(map2.put("it004", "陈浩南")); //null
        //如果调用put方法，产生了覆盖的效果，那么返回值就是被覆盖掉的值。
        System.out.println(map2.put("it004", "大幂幂")); //陈浩南
    }
}
