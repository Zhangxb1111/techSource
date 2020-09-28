package cn.itcast.demo00;

import java.util.Calendar;
import java.util.Date;

/*
    Calendar中月份是从0开始的。
    0 表示 1月
    1 表示 2月
    ...

    Date中，月份就是从1开始的。

 */
public class Demo01Calendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,2018);
        c.set(Calendar.MONTH,2);//已经赋值为2月了
        c.set(Calendar.DATE,14);
        Date time = c.getTime();
        System.out.println(time);// 为什么打印出来是3月?
    }
}
