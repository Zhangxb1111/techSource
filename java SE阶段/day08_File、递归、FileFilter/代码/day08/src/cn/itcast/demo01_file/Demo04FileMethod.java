package cn.itcast.demo01_file;

import java.io.File;

/*
    File类中的获取方法
    String getAbsolutePath​()： 获取这个File对象对应的绝对路径。
    String getPath​()：获取File对象对应的路径
    String getName​()： 获取File对象表示的文件或者文件夹的名字
    long length​()： 获取File对象表示的文件的大小（字节数）
                     一定要通过文件调用length，如果通过文件夹调用length方法，得到的是一个不确定的数字。
 */
public class Demo04FileMethod {
    public static void main(String[] args) {
        method4();
    }

    //long length​()： 获取File对象表示的文件的大小（字节数）
    public static void method4() {
        //创建File对象
        File file = new File("d:\\iotest\\aa.txt");
        //File file = new File("d:\\iotest");
        //调用方法，获取这个文件的字节数大小
        long len = file.length();
        System.out.println("len:" + len);
    }

    //String getName​()： 获取File对象表示的文件或者文件夹的名字
    public static void method3() {
        //创建一个File对象
        //File file = new File("d:\\iotest\\aa.txt");
        //File file = new File("d:\\iotest\\bb");
        File file = new File("d:\\iotest\\cc");
        //获取这个file对象表示的文件或者文件夹的名字
        String name = file.getName();
        System.out.println(name);
    }

    //String getPath​()：获取File对象对应的路径
    //如果创建File对象的时候使用的是绝对路径那么获取的就是绝对路径，如果使用的是相对路径那么获取的就是相对路径。
    public static void method2() {
        //创建一个File对象
        //File file = new File("d:\\iotest\\a.txt");
        File file = new File("a.txt");
        //获取这个File对象的路径
        String path = file.getPath();

        System.out.println(path);
    }

    //String getAbsolutePath​()： 获取这个File对象对应的绝对路径。
    public static void method1() {
        //创建一个File对象
        //File file = new File("d:\\iotest\\a.txt");
        File file = new File("a.txt");

        //调用方法，获取这个File对象对应的绝对路径
        String path = file.getAbsolutePath();

        System.out.println(path);
    }
}
