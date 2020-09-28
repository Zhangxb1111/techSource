package cn.itcast.demo04_stream常见方法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
    了解：
    如果要对流进行并发操作， 那么使用原来的Stream就会产生问题，我们可以使用并发流去解决

    并发流的获取方式。
        1. 使用普通流对象调用
            parallel​()： 获取对应的并发流

        2. 通过集合对象调用方法获取
            default Stream<E> parallelStream​() ：直接获取一个并发流
 */
public class Demo11Stream {
    public static void main(String[] args) {
        method2();
    }

    public static void method2() {
        //创建一个集合对象
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        //直接调用方法，获取到一个并发流
        Stream<String> stream = list.parallelStream();

        //逐一处理
        stream.forEach(System.out::println);
    }

    public static void method1() {
        //获取一个流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "张无忌", "张天爱", "张二狗");
        Stream<String> parallelStream = stream.parallel();//返回这个流对应的并发流
        parallelStream.forEach(System.out::println); //并发流逐一处理的时候是无序的。
        //parallelStream.forEachOrdered(System.out::println); //可以有序，但是会牺牲效率
    }
}
