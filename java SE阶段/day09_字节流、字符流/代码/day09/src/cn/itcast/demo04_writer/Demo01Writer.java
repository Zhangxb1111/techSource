package cn.itcast.demo04_writer;

import java.io.FileWriter;
import java.io.IOException;

/*
    在java中Write表示字符输出流， 可以将java程序中的数据写到文件中。
    Writer是所有字符输出流的顶层父类， 并且这个类是一个抽象类。一般使用子类。
    最常用的子类是FileWriter。

    FileWriter的构造方法：
        FileWriter​(File file)： 传递一个File类型的文件
        FileWriter​(String fileName)： 传递一个String类型的文件路径。

    FileWriter的其他方法：
        void write​(String str)：向文件中写入一个字符串数据。
        void flush​()：　刷新。　字符流写数据的时候一定要刷新。
        void close​()：　释放资源

    如果不刷新，则数据会在内存缓冲区中，而不会写到文件中。

    使用步骤：
        1. 创建
        2. 写入
        3. 刷新
        4. 释放
 */
public class Demo01Writer {
    public static void main(String[] args) throws IOException {
        //创建一个FileWriter对象
        FileWriter fw = new FileWriter("file04.txt");
        //调用write方法，向文件中写数据
        fw.write("你好啊，你今天早上洗头发了吗");

        //字符输出流调用write方法写的数据放入到了内存缓冲区中。
        //想要把数据从内存缓冲区放入文件中，则需要刷新
        fw.flush();

        //释放资源
        fw.close();
    }
}
