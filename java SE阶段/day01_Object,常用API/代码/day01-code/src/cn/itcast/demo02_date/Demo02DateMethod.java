package cn.itcast.demo02_date;

import java.util.Date;

/*
    在Date中有一个方法，可以获取这个Date对象对应的毫秒值。

        long getTime​()：获取到从1970年开始，到这个Date对象表示的时间，过了多少毫秒
 */
public class Demo02DateMethod {
    public static void main(String[] args) {
        //创建Date对象
        Date date = new Date();
        //获取这个Date对象对应的毫秒值。
        //ctrl + alt + v 直接生成返回值
        long time = date.getTime();
        System.out.println(time);

    }
}
