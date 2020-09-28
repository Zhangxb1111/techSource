package cn.itcast.demo02_function;

import java.util.function.Function;

/*
    在java中，有一个函数式接口Function，这个接口可以称为函数模型。 可以接收一个参数，并返回一个结果。

    Function<T,R> 有两个泛型， T表示接收的参数的数据类型， R表示的是返回的结果的类型

    比如；
        接收一个"10"， 可以经过处理，返回一个int类型的10


    抽象方法：
        R apply​(T t)： 接收一个T类型的参数，返回一个R类型的结果。

    默认方法：
        default <V> Function<T,V> andThen​(Function after)： 将两个Function合并成一个， 并且有先后顺序
                                                             a.andThen(b) 先a后b。


 */
public class Demo01Function {
    public static void main(String[] args) {
        //method(s -> Integer.parseInt(s));
        method(Integer::parseInt);
    }

    //使用Function函数式接口将字符串类型的"10"转成int类型的10
    public static void method(Function<String, Integer> function) {
        Integer num = function.apply("10");
        System.out.println(num);
    }
}
