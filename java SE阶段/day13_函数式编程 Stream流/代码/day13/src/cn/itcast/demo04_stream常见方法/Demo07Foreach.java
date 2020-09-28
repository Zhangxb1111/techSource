package cn.itcast.demo04_stream常见方法;

import java.util.stream.Stream;

/*
    如果希望对流中的元素进行逐一处理，那么可以使用foreach方法。

    void forEach​(Consumer action)：参数是一个Consumer。可以定义如何使用流中的每一个元素

    回忆Consumer， 这个接口表示的是消费者，可以去消费一个数据（使用这个数据干一些事情）

        void accept​(T t)：接收一个参数，然后使用这个参数去做一些事情。

 */
public class Demo07Foreach {
    public static void main(String[] args) {
        //获取一个流对象
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd");
        //对这个流对象中的内容进行逐一处理
        //stream.forEach(s -> System.out.println(s));

        stream.forEach(System.out::println);

    }
}
