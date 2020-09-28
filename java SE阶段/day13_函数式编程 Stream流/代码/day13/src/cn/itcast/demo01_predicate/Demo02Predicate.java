package cn.itcast.demo01_predicate;

import java.util.function.Predicate;

/*
    在Predicate中，有一个方法，叫做and，可以对两个Predicate进行合并，他们之间是并且的关系。 &&

    default Predicate<T> and​(Predicate other)： 对Predicate进行合并，合并之后的关系是并且的关系，相当于java中的&&

    比如：
        Predicate one： 用来判断字符串是否以指定的开头（比如以"hel"开头）
        Predicate two：用来判断字符串的长度是否是指定的（比如长度是５）

        如果对这两个Predicate合并
        判断是否以指定开头　&& 判断字符串长度是否满足要求
 */
public class Demo02Predicate {
    public static void main(String[] args) {
        /*method(s -> s.startsWith("hel"),
                s -> s.length() == 5);*/


        method(s -> s.startsWith("hea"),
                s -> {
                    System.out.println("hahaha");
                    return s.length() == 5;
                });
    }

    //使用one验证字符串是否以指定的开头
    //使用two验证字符串的长度是否满足规则
    //one 和two必须全部满足，所以他们是并且的关系
    public static void method(Predicate<String> one, Predicate<String> two) {
        /*
        boolean flagOne = one.test("hello");
        boolean flagTwo = two.test("hello");
        //如果是以指定的开头，并且这个字符串的长度也满足要求，那么就打印true
        boolean result = flagOne && flagTwo;
        System.out.println(result);
        */

        //简便写法，可以对两个Predicate进行合并，使用and方法合并之后的关系就是并且的关系
        //比如 a.and(b).test(...)
        //相当于 a.test(...) && b.test(...);
        //假如one调用test的结果是false，那么就不会执行two的test方法。
        boolean result = one.and(two).test("hello");
        System.out.println(result);

    }
}
