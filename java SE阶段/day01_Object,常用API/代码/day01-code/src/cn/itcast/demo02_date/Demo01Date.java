package cn.itcast.demo02_date;

import java.util.Date;

/*
    在java中，有一个类表示时间，这个类叫做Date。
    java.util.Date英语单词的意思是日期，但是在java中表示精确的时间瞬间（精确到了毫秒）。

    构造方法：
        Date​()：空参数构造，会以当前操作系统的时间构造一个Date对象。
        Date​(long date)： 传递一个毫秒值。 这个毫秒值指的是从1970年1月1日 0点0分0秒 开始过了多少毫秒。

    中国是东八区，时间要快八个小时， 时间是从 1970年1月1日 8点开始的。
 */
public class Demo01Date {
    public static void main(String[] args) {
        //使用空参数构造方法创建对象
        Date date1 = new Date();
        System.out.println("date1:" + date1);

        //使用有参构造创建对象
        Date date2 = new Date(0L);
        System.out.println("date2:" + date2);

        //创建一个Date对象，这个date对象表示的时间是1970年1月2日.
        Date date3 = new Date(1000 * 60 * 60 * 24);
        System.out.println("date3:" + date3);

    }
}
