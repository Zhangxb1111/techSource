package cn.itcast.demo03_outputstreamwrite_inputstreamread;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    InputStreamReader 是转换流，是字节流向字符的桥梁。

    将文件中的内容读取到Java程序中。
    所有的数据在文件中保存的都是字节。
    如果读取到java程序中，那么我们看到的就是字符


    InputStreamReader的作用是可以指定编码进行读取。
    其实InputStreamReader本身也不具备读的功能，它的功能查询码表以及转码。


    构造方法：
        InputStreamReader​(InputStream in)： 传递一个字节输入流。 并且这个构造方法创建出来的对象会采用默认编码方式进行读取。
        InputStreamReader​(InputStream in, String charsetName)：还需要传递一个字符串charsetName。这个表示采用哪个编码方式进行读取。

    使用步骤：
        １.　创建转换流对象，用来读取，并且指定一个编码方式。
        ２.　调用方法，进行读取。
        ３.　释放资源
 */
public class Demo02InputStreamReader {
    public static void main(String[] args) throws IOException {
        readUTF8();
    }

    public static void readUTF8() throws IOException {
        //创建转换流对象
        //采用默认编码方式进行读取，默认就是utf-8
        //InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\file02-utf8.txt"));

        InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\file02-utf8.txt"), "utf-8");
        //调用方法进行读取
        int i;
        while((i = isr.read()) != -1) {
            System.out.print((char) i);
        }
        //释放资源
        isr.close();
    }

    public static void readGBK() throws IOException {
        //１.　创建转换流对象，用来读取，并且指定一个编码方式。
        //采用的是平台默认的编码是utf-8
        //InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\file01-gbk.txt"));
        //指定GBK编码进行读取
        InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\file01-gbk.txt"), "gbk");
        //２.　调用方法，进行读取。
        int i;
        while((i = isr.read()) != -1) {
            System.out.print((char) i);
        }
        //３.　释放资源
        isr.close();
    }
}
