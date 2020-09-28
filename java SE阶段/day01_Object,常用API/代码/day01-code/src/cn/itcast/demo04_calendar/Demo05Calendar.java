package cn.itcast.demo04_calendar;

import java.util.Calendar;
import java.util.Date;

/*
    Calendar中的getTime方法，

    在Calendar中有一个方法，可以把Calendar转成Date对象。 用的就是getTime方法。
        Date getTime​()：获取Calendar对应的Date对象
 */
public class                                                                                        Demo05Calendar {
    public static void main(String[] args) {
        //1. 获取到一个Calendar对象
        Calendar c = Calendar.getInstance();

        //2. 调用getTime方法，把这个日历对象转成Date
        Date date = c.getTime();


        System.out.println(date);
    }
}
