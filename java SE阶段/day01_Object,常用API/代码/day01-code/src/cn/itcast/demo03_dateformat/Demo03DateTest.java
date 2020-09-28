package cn.itcast.demo03_dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    练习： 计算一个人活了多少天

    思路：
        1. 求出这个人的出生日期
            a. 键盘录入这个人的出生年月日，得到对应的字符串。
            b. 把这个字符串转成date对象
            c. 调用date对象的getTime获取到这个Date对象对应的毫秒值。
        2. 求出当前的时间日期
            a. 使用空参数构造创建一个Date对象。
            b. 调用这个Date对象的getTime方法，获取到对应的毫秒值。
        3. 做减法
            a. 当前时间的毫秒值减去出生日期的毫秒值。
 */
public class Demo03DateTest {
    public static void main(String[] args) throws ParseException {
        //1. 求出这个人的出生日期

        //a. 键盘录入这个人的出生年月日，得到对应的字符串。
        Scanner sc = new Scanner(System.in);
        System.out.println("请您键盘录入一个出生日期，格式为： yyyy-MM-dd");
        String bornStr = sc.nextLine();

        //b. 把这个字符串转成date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date born = sdf.parse(bornStr);

        //c. 调用date对象的getTime获取到这个Date对象对应的毫秒值。
        long bornMillis = born.getTime();

        //2. 求出当前的时间日期
        //a. 使用空参数构造创建一个Date对象。
        Date now = new Date();
        //b. 调用这个Date对象的getTime方法，获取到对应的毫秒值。
        long nowMillis = now.getTime();

        //3. 做减法
        long millis = nowMillis - bornMillis;
        System.out.println(millis / 1000 / 60 / 60 / 24);
    }
}
