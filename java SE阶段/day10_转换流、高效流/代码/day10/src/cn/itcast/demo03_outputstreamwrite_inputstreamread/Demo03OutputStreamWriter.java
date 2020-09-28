package cn.itcast.demo03_outputstreamwrite_inputstreamread;

import java.io.*;

/*
    OutputStreamWriter也是转换流， 是字符通向字节的桥梁。
    OutputStreamWriter可以指定编码进行写入。

    构造方法：
        OutputStreamWriter​(OutputStream out)： 使用默认的编码方式进行写入
        OutputStreamWriter​(OutputStream out, String charsetName): 指定编码方式进行写入。

    使用步骤：
        1. 创建一个OutputStreamWriter，并且指定一个编码方式
        2. 调用write方法，进行写入
        3. 释放资源

 */
public class Demo03OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        writeUtf8();
    }

    //向文件写入UTF-8编码的数据
    public static void writeUtf8() throws IOException {
        //创建一个OutputStreamWriter，指定一个编码方式
        //采用的是默认编码，默认的就是UTF-8
        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:\\file04-utf8.txt"));

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:\\file04-utf8.txt"), "utf-8");

        //调用方法，写入
        osw.write("你好");
        //调用方法，释放资源
        osw.close();
    }

    //写GBK
    public static void writeGBK() throws IOException {
        //1. 创建一个OutputStreamWriter，并且指定一个编码方式
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:\\file03-gbk.txt"), "gbk");
        //2. 调用write方法，写入数据
        osw.write("你好");
        //3. 调用close方法释放资源
        osw.close();
    }
}
