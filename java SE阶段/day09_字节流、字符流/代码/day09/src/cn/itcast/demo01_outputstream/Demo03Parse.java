package cn.itcast.demo01_outputstream;

import java.util.Arrays;

/*
    字符串和字节输出的相互转换。

    字符串->字节数组
        byte[] getBytes​()： 使用平台默认的编码方式将字符串转成字节数组。

    字节数组 -> 字符串
        String​(byte[] bytes)： 将字节数组转成一个字符串
        String​(byte[] bytes, int offset, int length)： 将字节数组的一部分转成String。
            参数bytes： 表示要转换的字节数组
            参数offset： 表示从哪个位置开始转
            参数length： 表示转几个.
 */
public class Demo03Parse {
    public static void main(String[] args) {
        //定义一个字符串
        String s1 = "abcde";
        //调用方法，把这个字符串转成字节数组
        byte[] bArr = s1.getBytes();
        System.out.println(Arrays.toString(bArr)); //[97, 98, 99, 100, 101]

        String s2 = "中文";
        byte[] bArr2 = s2.getBytes();
        System.out.println(Arrays.toString(bArr2));

        System.out.println("------------------------------------");

        //字节数组 -> 字符串
        String str1 = new String(bArr);
        System.out.println("str1:" + str1); //abcde
        String str2 = new String(bArr, 1, 3);//将bArr转成字节数组，从索引为1的位置开始，转3个
        System.out.println("str2:" + str2);
    }
}
