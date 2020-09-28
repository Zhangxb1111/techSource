package cn.itcast.demo03_dateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    如果想要把一个字符串转成一个Date对象，同样也可以使用SimpleDateFormat去转换。

    使用的是另一个方法
        Date parse​(String source)： 将一个字符串转成一个Date对象。

    注意：
        1. 要转的这个字符串必须是一个能够解析的时间
        2. 字符串的格式必须和SimpleDateFormat中的模式一致。

    当调用parse方法时，下面会有一个红线，此时需要抛出一个异常， alt + 回车，选择第一个


    总结：
        Date对象转字符串：
            调用SimpleDateFormat的format方法就可以了。 也叫作格式化。
        字符串转Date对象
            调用SimpleDateFormat的parse方法就可以了。  也叫作解析。
 */
public class Demo02DateFormat {
    public static void main(String[] args) throws ParseException {
        //创建字符串
        String str = "2000-07-04 11:07:56";

        //1. 创建一个SimpleDateFormat对象，指定一个模式。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //2. 调用parse方法，将字符串转成Date对象
        Date date = sdf.parse(str);

        //3. 打印
        System.out.println(date);
    }
}
