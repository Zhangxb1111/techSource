package cn.itcast.demo03_stream;

import java.util.*;
import java.util.stream.Stream;

/*
    在java中，获取流有三种途径

    1. 通过Collection集合进行获取。
    2. 通过Map集合进行获取
    3. 通过数组进行获取。


    如果要通过Collection集合获取流对象，那么可以调用集合的stream()方法
        default Stream<E> stream​()： 获取到集合对应的流对象。

 */
public class Demo03GetStream {
    public static void main(String[] args) {
        //创建一个List集合
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("aaa");
        list.add("bbb");
        list.add("xxx");
        list.add("yyy");
        //获取到这个集合对应的流对象
        Stream<String> stream = list.stream();
        System.out.println(Arrays.toString(stream.toArray()));//把stream流转成数组并打印


        //创建一个Set集合
        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();
        System.out.println(stream2);
    }
}
