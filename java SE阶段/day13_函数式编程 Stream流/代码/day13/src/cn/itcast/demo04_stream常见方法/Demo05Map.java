package cn.itcast.demo04_stream常见方法;

import java.util.Arrays;
import java.util.stream.Stream;

/*
    在Stream中有一个方法，可以将一个流中的元素映射到另一个流中。

    原来流：
    stream1： "10", "20", "30"
    映射后：
    stream2：  10    20    30

    如果需要映射，需要使用Stream中的map方法
        <R> Stream<R> map​(Function mapper)：需要一个Function类型的参数，参数可以定义映射的规则。

    回顾Function， 这个接口表示的是函数模型，可以接收一个参数并且返回一个结果。
        R apply​(T t)： 接收一个T类型的参数，返回一个R类型的结果

 */
public class Demo05Map {
    public static void main(String[] args) {
        //创建Stream流
        Stream<String> stream = Stream.of("10", "20", "30", "40");
        //调用map方法，将原来stream流中的内容映射到一个新的Stream中，新的stream里面放的是数字
        Stream<Integer> newStream = stream.map(s -> Integer.parseInt(s));

        //打印newStream中的内容
        System.out.println(Arrays.toString(newStream.toArray()));
    }

}
