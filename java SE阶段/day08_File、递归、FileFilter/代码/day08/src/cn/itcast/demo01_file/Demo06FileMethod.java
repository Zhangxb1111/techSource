package cn.itcast.demo01_file;

import java.io.File;
import java.io.IOException;

/*
    File里面的创建功能
        boolean createNewFile​()： 创建一个文件，如果文件已经存在，那么则创建失败。
        boolean mkdir​()： 创建一个文件夹，如果文件夹已经存在，那么则创建失败。
        （推荐）boolean mkdirs​()： 创建一个文件夹，如果文件夹已经存在，那么则创建失败。

    mkdir和mkdirs的区别：
        mkdir：只能创建单级目录， 如果上级目录不存在，则创建失败
        mkdirs：可以创建多级目录，如果上级目录不存在，也会创建上级目录。
 */
public class Demo06FileMethod {
    public static void main(String[] args) throws IOException {
        method3();
    }

    //boolean mkdirs​()： 创建一个文件夹，如果文件夹已经存在，那么则创建失败。
    public static void method3() {
        //创建File对象
        //File file = new File("d:\\iotest\\ee");
        //如果上级目录不存在，会一起创建上级目录。
        File file = new File("d:\\iotest1\\ee");
        boolean flag = file.mkdirs();
        System.out.println("flag:" + flag);
    }

    //boolean mkdir​()： 创建一个文件夹，如果文件夹已经存在，那么则创建失败。
    public static void method2() {
        //创建一个File对象
        //File file = new File("d:\\iotest\\dd");
        //File file = new File("d:\\iotest\\ee.txt");
        //如果文件夹对应的上级目录不存在，那么就会创建失败返回false。
        File file = new File("d:\\iotest1\\ee");

        //通过mkdir方法创建一个文件夹
        boolean flag = file.mkdir();
        System.out.println("flag:" + flag);

    }

    //boolean createNewFile​()： 创建一个文件，如果文件已经存在，那么则创建失败。
    public static void method1() throws IOException {
        //创建一个File对象
        //File file = new File("d:\\iotest\\cc.txt");
        //File file = new File("d:\\iotest\\新建文件夹");

        //如果上级目录不存在那么则直接抛出异常。
        File file = new File("d:\\iotest1\\dd.txt");

        //调用File对象的createNewFile方法，创建这个文件
        boolean flag = file.createNewFile();
        System.out.println("flag:" + flag);
    }
}
