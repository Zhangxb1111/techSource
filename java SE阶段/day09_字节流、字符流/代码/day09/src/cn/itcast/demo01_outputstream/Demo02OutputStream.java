package cn.itcast.demo01_outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    在java中OutputStream表示字节输出流，可以将java程序中的数据写到文件中。
    OutputStream是所有字节输出流的顶层父类，是一个抽象类，如果要用，需要使用子类。
    常用的子类FileOutputStream

    构造方法：
        FileOutputStream​(File file)： 传递File类型的文件。
        FileOutputStream​(String name)： 传递一个字符串类型的文件路径。

    常用方法：
        void write​(int b)： 向文件中写入一个字节。
        void write​(byte[] b)： 向文件中写入一个字节数组。
        void write​(byte[] b, int off, int len)： 向文件中写入字节输入的一部分。
        void close​()： 释放资源.

    FileOutputStream的使用步骤
    1. 创建一个FileOutputStream对象，并且指定一个目的地文件
    2. 调用write方法，向文件中写入数据。
    3. 释放资源（关闭流）

    注意： 在java中，一个字符占两个字节，但是如果这个字符在ASCII码范围内，那么这个字符在计算机
    中是占一个字节的，可以以一次写一个字节的方式写入到文件中.


    中文在操作系统中占多个字节的。 如果文件采用的是GBK编码，那么这个中文就占2个字节。
    如果文件采用的是UTF-8编码，那么这个中文占3个字节。
 */
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        //1. 创建一个FileOutputStream对象，并且指定一个目的地文件
        /*
            这一行代码做了哪些操作
            a. 会调用系统资源，在当前项目下创建一个文件叫做file01.txt。 如果文件已经存在，也会创建并且会覆盖原来的文件。
            b. 会创建一个字节输出流对象
            c. 将这个文件绑定到这个输出流对象上，以后通过这个输出流对象操作的就都是这个文件了。
         */
        FileOutputStream fos = new FileOutputStream("file01.txt");

        //2. 调用write方法，向文件中写入数据。
        //void write​(int b)： 向文件中写入一个字节。
        fos.write(100); //d
        //fos.write('a');
        //fos.write('中'); //这种方式不能向文件中写入中文

        //如果不释放资源，那么如果这个程序不结束的话，这个资源会一直处于被占用的状态.
        //3. 释放资源（关闭流）
        fos.close();
        /*
        while(true) {

        }
        */
    }
}
