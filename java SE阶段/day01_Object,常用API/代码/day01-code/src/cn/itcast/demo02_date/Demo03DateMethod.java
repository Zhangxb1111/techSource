package cn.itcast.demo02_date;

import java.util.Date;

/*
    Date中设置毫秒值的方法
        void setTime​(long time)：参数是一个毫秒值。

 */
public class Demo03DateMethod {
    public static void main(String[] args) {
        //创建一个Date对象
        Date date = new Date();
        System.out.println(date);

        //给这个Date对象设置毫秒值。
        date.setTime(0L);

        System.out.println(date);
    }
}
