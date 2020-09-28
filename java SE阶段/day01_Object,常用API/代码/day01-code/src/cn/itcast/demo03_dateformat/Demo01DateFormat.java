package cn.itcast.demo03_dateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    如果想把Date对象转成我们自己喜欢的字符串，可以使用DateFormat对Date对象进行格式化。

    DateFormat是一个抽象类， 所以要使用DateFormat的子类 SimpleDateFormat

    SimpleDateFormat的构造方法：
        SimpleDateFormat​(String pattern)： 使用指定的模式创建一个SimpleDateFormat对象。参数pattern表示模式。

    模式指的就是转换的格式。

    日期对应格式： 1999年11月11日 08点09分54秒
    日期对应模式： yyyy年MM月dd日 HH点mm分ss秒。

    要使用英语字母替换掉日期格式中的数字。
    y：表示年
    M：表示月
    d：表示日
    H：表示时
    m：表示分
    s：表示秒

    成员方法：
        String format​(Date date)： 将一个Date对象根据给出的模式转成String。
 */
public class Demo01DateFormat {
    public static void main(String[] args) {
        //创建Date对象
        Date date = new Date();

        //1. 创建SimpleDateFormat对象，给出指定的模式
        //希望转成的格式：  1999年11月11日 08点09分54秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒");

        //希望转成的格式： 1999-11-20 10:03:56
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //2. 调用format方法，将Date对象转成字符串
        String str = sdf.format(date);
        System.out.println(str);
    }
}
