package cn.itcast.demo04_calendar;

import java.util.Calendar;

/*
    在Date中很多方法都已经过时了，因为                                                                                                有更好的方法可以代替，这些更好的方法在Calendar中。

    在java中Calendar表示的是日历类。和Date一样，Calendar也能够表示精确的时间瞬间。

    Calendar是一个抽象类，所以不能直接new对象，如果我们要用需要使用它的子类。

    注意： Calendar的子类对象不是new出来的。要通过Calendar的静态方法进行获取。

        static Calendar getInstance​()： 获取到一个日历对象（返回的是Calendar子类对象）

    注意和之前的区别：
        之前创建对象一般都是直接new
        现在这个Calendar获取对象的时候要调用getInstance方法进行获取。
 */
public class Demo01Calendar {
    public static void main(String[] args) {
        //获取Calendar对象
        Calendar c = Calendar.getInstance();
        System.out.println(c);
    }
}
