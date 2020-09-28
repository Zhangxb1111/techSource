package cn.itcast.demo04_calendar;

import java.util.Calendar;

/*
    在Calendar中有一个方法，可以对指定的字段进行计算，这个方法叫做add。
        void add​(int field, int amount)： 表示对指定的字段进行计算
            参数field： 表示要对哪个字段进行计算。
            参数amount： 是对字段加上指定值呢还是减去指定值呢
                         如果这个参数是正数，就表示在原来的数据基础上加上这个数字
                         如果这个参数是负数，就表示在原来数据的基础上减去这个数字。

 */
public class                                   Demo04Calendar {
    public static void main(String[] args) {
        //获取到一个Calendar对象
        Calendar c = Calendar.getInstance();
        //打印这个日历对象的内容
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + '-' + c.get(Calendar.DAY_OF_MONTH));

        //对日历对象的字段进行计算

        //把年加上2
        //c.add(Calendar.YEAR, 2);
        //c.add(Calendar.YEAR, -2); //表示年往前移动了两年。

        //对月进行计算
        c.add(Calendar.MONTH, 6);

        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + '-' + c.get(Calendar.DAY_OF_MONTH));

    }
}
