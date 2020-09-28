package cn.itcast.demo12_常用的函数式接口;

import java.util.function.Consumer;

/*
    在java.util.function包下，还有一个函数式接口叫做Consumer，这个接口表示消费者，可以消费一个数据(使用这个数据去干一些事情)

    Consumer<T>接口中的抽象方法：
        void accept​(T t)： 消费一个数据。 接收到参数t，然后使用这个t。
 */
public class Demo02Consumer {
    public static void main(String[] args) {
        //method(s -> System.out.println(s));

        method(System.out::println);
    }

    public static void method(Consumer<String> c) {
        c.accept("Hello");
    }
}
