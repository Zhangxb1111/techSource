package cn.itcast.demo02_inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    在java中InputStream是字节输入流，用来将文件中的数据读取到java程序中。
    InputStream是所有字节输入流的顶层父类，是一个抽象类。如果要用，需要使用子类。

    最常用的子类：FileInputStream。

    构造方法：
        FileInputStream​(File file)： 传递一个File类型的文件
        FileInputStream​(String name)： 传递一个String类型的文件路径

    其他方法：
        int read​()： 从文件中读取一个字节数的数据。并返回读取到的这个字节。 如果读取结束，返回的是-1.
        int read​(byte[] b)： 一次读取一个字节数组，输入流会把读取到的内容放入到这个字节数组中，并返回读取到的个数， 如果读取结束返回-1.
        void close​()

    使用步骤：
        1. 创建一个FileInputStream流对象，绑定一个数据源文件。
        2. 调用read方法读取数据。
        3. 释放资源

    注意： 这种方式不能读取中文，一个中文占多个字节，此时一次读取一个字节会把中文拆开读。
 */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        //1. 创建一个FileInputStream流对象，绑定一个数据源文件。
        //注意：如果文件不存在，就会抛出异常（FileNotFoundException）
        FileInputStream fis = new FileInputStream("source01.txt");

        //2. 调用read方法读取数据。
        // int read​()： 从文件中读取一个字节数的数据。并返回读取到的这个字节。 如果读取结束，返回的是-1.

        //使用循环去读取文件中的字节。
        //定义一个变量，用来保存每次读取到的字节
        int i;
        //开始读取
        while ((i = fis.read()) != -1) {
            /*
                条件做了下面的事情
                1. 通过fis输入流调用read方法，读取一个字节。
                2. 把读取到的这个字节赋值给变量i。
                3. 判断i是否不等于-1，如果不是-1表示读取到了内容，就在循环中对读取到的内容进行处理。
                读取到的内容在i里面保存
             */
            System.out.print((char) i);
        }


        /*
        int i = fis.read();
        System.out.println(i); // 97

        i = fis.read();
        System.out.println(i); // 98

        i = fis.read();
        System.out.println(i); // 99

        i = fis.read();
        System.out.println(i); // -1
        */

        //3. 释放资源
        fis.close();
    }
}
