package cn.itcast.demo12_常用的函数式接口;

import java.util.function.Supplier;

/*
    在jdk8之后，多了java.util.function 。这个包下面放了很多的常用的函数式接口。

    其中有一个接口叫做Supplier<T>（生产者）， 里面有一个方法，可以获取一个对象。

    T get​()： 可以获取一个对象。


 */
public class Demo01Supplier {
    public static void main(String[] args) {
        method(() -> "你好");
    }

    public static void method(Supplier<String> supplier) {
        String str = supplier.get();
        System.out.println(str);
    }
}
