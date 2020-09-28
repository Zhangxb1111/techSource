package cn.itcast.demo04_calendar;

import java.util.Calendar;

/*
    在Calendar中有一个方法，可以获取指定字段的值。
        int get​(int field)：可以获取日历对象中指定字段的值。

    get(年)： 获取年的值。
    get(月)： 获取月的值
    get(日)： 获取日的值

    参数是一个int数字，要使用int数字表示每个字段。
    1表示的是年。 2表示的是月....

    如果每次调用get方法，都传递数字，会大大的影响开发效率以及程序的阅读行。

    如何解决：
        我们可以使用Calendar中的经常常量来表示这些数字。
        在Calendar提供了很多的静态常量，每一个静态常量都对应一个数字，并且这个常量名字可以做到见名之意的效果

    注意：在Calendar中，月份是从0开始的，比我们现实要少1
*/
public class Demo02Calendar {
    public static void main(String[] args) {
        //1. 获取到一个Calendar对象
        Calendar c = Calendar.getInstance(); //和Date一样，这个Calendar表示的时间是当前操作系统的时间。

        //2. 调用get，获取指定字段的值
        int year = c.get(Calendar.YEAR); //获取年
        System.out.println("year:" + year);

        int month = c.get(Calendar.MONTH); //获取月
        System.out.println("month:" + (month + 1));

        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("day:" + day);

        //获取今天是一年中的第几天
        int dayOfYear = c.get(Calendar.DAY_OF_YEAR);
        System.out.println("dayOfYear:" + dayOfYear);
    }
}
