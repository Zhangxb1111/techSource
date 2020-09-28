package cn.itcast.demo04_stream常见方法;

import java.util.Arrays;
import java.util.stream.Stream;

/*
    在Stream中，有一个方法，叫做filter，可以过滤掉流中不想要的内容，并且会把留下来的内容放入到
    一个新的Stream流对象中并返回。

    Stream<T> filter​(Predicate predicate)： 根据条件过滤掉不想要的内容，留下想要的。
                                             参数是Predicate，用来编写过滤的条件。



    回顾Predicate的作用，可以验证一个数据是否满足要求
        boolean test​(T t)：用来验证一个数据是否合法。　如果合法，返回true

 */
public class Demo01Filter {
    public static void main(String[] args) {
        //获取一个Stream流对象
        Stream<String> stream = Stream.of("aaa", "bb", "ccc", "dd", "eeee");
        //调用filter方法，进行过滤。留下长度大于2的字符串
        Stream<String> stream2 = stream.filter(s -> s.length() > 2);

        //打印过滤后的结果
        System.out.println(Arrays.toString(stream2.toArray())); //[aaa, ccc, eeee]

        System.out.println(stream == stream2); //false
    }
}
