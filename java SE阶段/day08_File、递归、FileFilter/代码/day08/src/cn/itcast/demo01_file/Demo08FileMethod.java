package cn.itcast.demo01_file;

import java.io.File;

/*
    File里面的遍历功能。

    File里面有一些方法，可以获取指定目录下面的所有的内容（文件或者文件夹）

    String[] list​()：获取指定目录下所有的文件和文件夹
    （重要）File[] listFiles​()： 获取指定目录下所有的文件和文件夹。


    如果调用上面方法，File对象所表示的文件夹中没有任何内容，得到的是一个空数组
    File[] files = {};

    如果File对象表示的是一个文件，那么得到的是一个null值
    File[] files = null;
 */
public class Demo08FileMethod {
    public static void main(String[] args) {
        method3();
    }

    //注意事项
    public static void method3() {
        //创建一个File对象
        File file = new File("d:\\iotest\\aa.txt");
        File[] files = file.listFiles();

        System.out.println(files);

        System.out.println(files.length);

        for(File thisFile : files) {
            System.out.println(thisFile);
        }
    }

    //File[] listFiles​()： 获取指定目录下所有的文件和文件夹。
    public static void method2() {
        //创建一个File对象
        File file = new File("d:\\iotest");
        //调用listFiles​，获取这个File对象所表示的目录下面的所有文件和文件夹
        File[] files = file.listFiles();
        //遍历
        for(File thisFile : files) {
            System.out.println(thisFile);
        }
    }

    //String[] list​()：获取指定目录下所有的文件和文件夹
    public static void method1() {
        //创建File对象
        File file = new File("d:\\iotest");

        //调用list方法，获取file所表示目录下面的所有文件和文件夹
        String[] files = file.list();
        //遍历
        for(String thisFile : files) {
            System.out.println(thisFile);
        }
    }
}
