package cn.itcast.demo03_stream;

import java.util.*;
import java.util.stream.Stream;

/*
    在java中，也可以使用Map集合去获取一个流对象， Map是一个双列集合，所以不能直接获取对应的流对象。

    获取方式：
        1. 先获取到Map集合中所有的key，然后获取所有key的Stream流。
        2. 先获取到Map集合中的所有的value，然后获取所有value的stream流
        3. 先获取Map集合中的所有的Entry， 然后获取所有的entry对象的流
 */
public class Demo04GetStream {
    public static void main(String[] args) {
        //创建Map集合
        Map<String, String> map = new HashMap<>();
        //添加元素
        map.put("it001", "东方不败");
        map.put("it002", "金毛狮王");
        map.put("it003", "孙悟空");

        //1. 先获取到Map集合中所有的key，然后获取所有key的Stream流。
        Set<String> keySet = map.keySet();
        Stream<String> keyStream = keySet.stream();
        System.out.println(Arrays.toString(keyStream.toArray()));

        //2. 先获取到Map集合中的所有的value，然后获取所有value的stream流
        Collection<String> valueSet = map.values(); //获取map集合中的所有value
        Stream<String> valueStream = valueSet.stream();
        System.out.println(Arrays.toString(valueStream.toArray()));

        //3. 先获取Map集合中的所有的Entry， 然后获取所有的entry对象的流
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Stream<Map.Entry<String, String>> entryStream = entrySet.stream();
        System.out.println(Arrays.toString(entrySet.toArray()));


    }
}
