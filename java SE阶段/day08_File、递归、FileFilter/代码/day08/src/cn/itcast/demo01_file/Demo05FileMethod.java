package cn.itcast.demo01_file;

import java.io.File;

/*
    File类中的判断功能

    boolean exists​()： 判断File对象表示的文件夹或者文件是否存在。
    boolean isDirectory​()：判断File对象表示的是否是文件夹
    boolean isFile​()： 判断File对象表示的是否是文件
 */
public class Demo05FileMethod {
    public static void main(String[] args) {
        method3();
    }

    //boolean isFile​()： 判断File对象表示的是否是文件
    public static void method3() {
        //创建一个File对象
        //File file = new File("d:\\iotest\\aa.txt");
        File file = new File("d:\\iotest\\cc");
        //调用方法，判断是否是文件
        boolean flag = file.isFile();
        System.out.println("flag:" + flag);
    }

    //boolean isDirectory​()：判断File对象表示的是否是文件夹
    public static void method2() {
        //创建一个File对象
        //File file = new File("d:\\iotest\\aa.txt");
        //File file = new File("d:\\iotest\\bb");
        File file = new File("d:\\iotest\\cc");

        //调用方法，判断是否是文件夹
        boolean flag = file.isDirectory();
        System.out.println("flag:" + flag);
    }


    //boolean exists​()： 判断File对象表示的文件夹或者文件是否存在。
    public static void method1() {
        //创建一个File对象
        //File file = new File("d:\\iotest\\aa.txt");
        //File file = new File("d:\\iotest\\bb");
        File file = new File("d:\\iotest\\cc");
        //调用方法，判断这个File对象表示的文件夹或者文件是否存在。
        boolean flag = file.exists();
        System.out.println("flag:" + flag);
    }
}
