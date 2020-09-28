package cn.itcast.demo01_bufferedstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    测试 复制文件使用的时间

    字节流一次读写一个字节的方式去复制图片
    7078ms
 */
public class Demo01FileCopy {
    public static void main(String[] args) throws IOException {
        //创建一个字节输入流
        FileInputStream fis = new FileInputStream("aa.jpg");
        //创建一个字节输出流
        FileOutputStream fos = new FileOutputStream("bb.jpg");

        //复制之前记录一下时间
        long start = System.currentTimeMillis();

        //开始复制，每读取一个字节，就把读取到的字节写入到目的地文件
        int i;
        while((i = fis.read()) != -1) {
            fos.write(i);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

        //释放资源
        fos.close();
        fis.close();
    }
}
