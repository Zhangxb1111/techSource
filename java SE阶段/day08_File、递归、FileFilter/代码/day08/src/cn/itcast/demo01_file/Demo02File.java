package cn.itcast.demo01_file;

import java.io.File;

/*
    File类的构造方法：

    File​(String pathname)： 参数需要传递一个字符串类型的文件或者文件夹的路径。
    File​(String parent, String child)：根据父路径和子路径组合构造一个File对象。
                        比如： 一个文件的路径是  d:\iotest\a\b.txt
                        那么对应的父路径是： d: \iotest\a
                        那么对应的子路径是： b.txt
    File​(File parent, String child)：根据父路径和子路径组合构造一个File对象

 */
public class Demo02File {
    public static void main(String[] args) {
        method3();
    }

    //File​(File parent, String child)：根据父路径和子路径组合构造一个File对象
    public static void method3() {
        //使用父路径和子路径组合构造一个File对象，这个File对象表示计算机中的d:\iotest\aa.txt

        File parent = new File("d:\\iotest");
        File file = new File(parent, "aa.txt");
        System.out.println(file);
    }

    //File​(String parent, String child)：根据父路径和子路径组合构造一个File对象。
    public static void method2() {
        //使用父路径和子路径组合构造一个File对象，这个File对象表示计算机中的d:\iotest\aa.txt
        File file = new File("d:\\iotest", "aa.txt");
        System.out.println(file);

    }


    //File​(String pathname)： 参数需要传递一个字符串类型的文件或者文件夹的路径。
    public static void method1() {
        //java中反斜线\ 是转义字符。 用来对后面的字符改变含义。
        //如果想要表示一个普通的\，需要写\\
        File file = new File("d:\\iotest\\aa.txt");
        System.out.println(file);
    }
}
