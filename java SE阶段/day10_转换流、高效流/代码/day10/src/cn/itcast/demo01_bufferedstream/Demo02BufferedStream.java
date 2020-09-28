package cn.itcast.demo01_bufferedstream;

import java.io.*;

/*
    缓冲流

    字节缓冲流：
        字节输入缓冲流：BufferedInputStream
        字节输出缓冲流：BufferedOutputStream
    字符缓冲流：
        字符输入缓冲流：BufferedReader
        字符输出缓冲流：BufferedWriter


    缓冲流特点是快，因为内部有一个缓冲区，可以提高效率。
    缓冲流其实本身并不具备读或者写的功能，它的作用其实是为其他流加速。

    缓冲流的使用步骤(和我们昨天学的流一样)：
        1. 创建一个缓冲流对象。
        2. 调用read方法读或者调用write方法写。 （读或者写的方法和我们昨天学的一模一样）
        3. 释放资源。

    字节缓冲流的构造方法
        BufferedInputStream​(InputStream in)：参数需要传递字节输入流。
        BufferedOutputStream​(OutputStream out)： 参数需要传递字节输出流。


    使用缓冲流完成文件的复制
    //185ms
 */
public class Demo02BufferedStream {
    public static void main(String[] args) throws IOException {
        //创建字节缓冲输入流用来读取。
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("aa.jpg"));
        //创建字节缓冲输出流用来写入
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bb.jpg"));

        long start = System.currentTimeMillis();

        //开始复制，每读取一个字节，就把读取到的这个字节写入到目的地中
        int i;
        while ((i = bis.read()) != -1) {
            bos.write(i);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
        //释放资源
        bos.close();
        bis.close();

    }
}
