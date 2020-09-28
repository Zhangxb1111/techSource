package cn.itcast.demo07_warp;
/*
    基本类型和字符串的相互转换

    基本类型转字符串：
        最常用： 直接把这个数字加上空字符串
        1.   12 + ""

        其他方法：不常用
        2. 使用String的静态方法valueOf进行转换
        3. 调用其包装类的toString方法。

    字符串转基本类型：
        如果转int类型，就调用Integer的静态方法parseInt
        如果转double类型，就调用Double的静态方法parseDouble
        如果转long类型，就调用Long的静态方法parseLong

        调用对应包装类的parseXXX方法即可。
        
        要转换的字符串必须是一个合法的数字，不然会报错.

        Integer里面有一个valueOf方法，也可以把字符串转成对应的数字。
 */
public class Demo03Parse {
    public static void main(String[] args) {

        //基本类型转字符串：
        int num = 12;
        String numStr = num + "";
        //String numStr = String.valueOf(num);
        //String numStr = Integer.valueOf(12).toString();
        System.out.println(numStr);
        System.out.println("--------------------------------");

        //定义一个字符串
        String str = "8777";
        //转成对应的数字
        int a = Integer.parseInt(str);
//        Integer a = Integer.valueOf(str);
        System.out.println("a:" + a);

    }
}
