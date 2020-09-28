package cn.itcast.demo00_反馈;

import java.math.BigDecimal;

/*
    小数在计算机中本身就是不精确的。

    1. 使用BigDecimal这个类去计算。
       这个类可以看成精确的小数.

    2. 直接使用字符串去计算。
    3. 直接使用整数。 10.24 * 100 -> 1024
 */
public class Demo01Test {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1.3");
        BigDecimal b = new BigDecimal("1.6");
        //调用方法，让这连个数字相加
        BigDecimal sum = a.add(b);
        System.out.println(sum);
    }
}
