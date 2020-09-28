package cn.itcast.demo04_calendar;

import java.util.Calendar;

/*
    如果想给Calendar中指定字段设置值，那么可以使用里面的set方法。
        void set​(int field, int value)： 给指定字段设置值。
            参数field：表示给哪个字段设置值
            参数value：表示设置成什么值。


 */
public class       Demo03Calendar {
    public static void main(String[] args) {
        //获取一个Calendar对象
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + '-' + c.get(Calendar.DAY_OF_MONTH));

        //调用set方法，给Calendar对象重新设置值

        //给年重新设置值，设置成2000
        c.set(Calendar.YEAR, 2000);

        //给月设置值，设置成3月
        c.set(Calendar.MONTH, 2);

        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + '-' + c.get(Calendar.DAY_OF_MONTH));

    }
}
