package cn.itcast.demo02_bufferedstream;

import java.io.*;

/*
    字符缓冲流：
        字符输出缓冲流： BufferedWriter
        字符输入缓冲流： BufferedReader

    字符缓冲流本身也不具备读或者写的功能，它的作用是为其他流提供加速。

    使用步骤和昨天学的基本的字符流基本一致。

    步骤
        1. 创建缓冲流对象
        2. 调用write方法写或者调用read方法读。 （读或者写的方法和昨天学的一样）
        3. 刷新（字符流写的时候要刷新， 读的时候不需要刷新）
        4. 释放资源


    字符缓冲流的构造方法：
        BufferedWriter​(Writer out)：传递一个字符输出流。
        BufferedReader​(Reader in)： 传递一个字符输入流

 */
public class Demo01BufferedStream {
    public static void main(String[] args) throws IOException {
        method2();
    }

    //BufferedReader​(Reader in)： 传递一个字符输入流
    public static void method2() throws IOException {
        //创建一个字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("file01.txt"));

        //调用read方法，进行读取。

        //一次读取一个字符
        /*
        int i;
        while ((i = br.read()) != -1) {
            System.out.print((char) i);
        }
        */

        //一次读取一个字符数组
        char[] cArr = new char[1024];
        int len;
        while((len = br.read(cArr)) != -1) {
            System.out.print(new String(cArr, 0, len));
        }


        //释放资源
        br.close();
    }

    //使用字符缓冲流向文件中写数据
    public static void method1() throws IOException {
        //创建一个字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("file01.txt"));
        //调用方法，写数据
        bw.write("你好，你今天早上做头发了吗");
        //刷新
        bw.flush();
        //释放资源
        bw.close();
    }
}
