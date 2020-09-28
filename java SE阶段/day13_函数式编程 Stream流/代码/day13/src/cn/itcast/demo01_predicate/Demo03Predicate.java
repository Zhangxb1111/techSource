package cn.itcast.demo01_predicate;

import java.util.function.Predicate;

/*
    在Predicate中，有一个方法，叫做or，可以对两个Predicate进行合并，结果是或者的关系。

    default Predicate<T> or​(Predicate other)： 对Predicate进行合并，合并之后的关系是或者的关系，相当于java中的||

    比如：
        one.test(...)
        two.test(...)
        再使用||进行连接

        合并之后：
        one.test(...) || two.test();

        式子可以表示为：
        one.or(two).test(...)

 */
public class Demo03Predicate {
    public static void main(String[] args) {
        method(s -> s.startsWith("hhh"),
                s -> s.length() == 5);
    }

    /*
        参数给两个Predicate
        Predicate one： 用来验证字符串是否以指定的开头
        Predicate two： 用来验证字符串的长度是否满足要求
        要求这两个结果之间是或者的关系，有一个成立，整个的结果就成立
     */
    public static void method(Predicate<String> one, Predicate<String> two) {
        /*
        boolean flagOne = one.test("hello");
        boolean flagTwo = two.test("hello");
        boolean result = flagOne || flagTwo;
        System.out.println("result:" + result);
        */

        //将两个Predicate合并成一个，合并之后的结果是或者的关系

        //相当于 one.test("hello") || two.test("hello")
        boolean result = one.or(two).test("hello");
        System.out.println("result:" + result);
    }
}
