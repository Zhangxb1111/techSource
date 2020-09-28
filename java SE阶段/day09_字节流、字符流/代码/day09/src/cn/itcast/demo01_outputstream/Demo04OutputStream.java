package cn.itcast.demo01_outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    使用字节输出流向文件中一次写一个字节数组

    方法：
        void write​(byte[] b)： 向文件中写入一个字节数组。
        void write​(byte[] b, int off, int len)： 向文件中写入字节输入的一部分。
 */
public class Demo04OutputStream {
    public static void main(String[] args) throws IOException {
        //创建一个字节输出流，绑定一个目的地文件
        FileOutputStream fos = new FileOutputStream("file01.txt");
        //调用write方法，向文件中写入字节数组
        byte[] bArr = "abcde".getBytes();
        //fos.write(bArr);

        fos.write(bArr, 1, 3);

        //释放资源
        fos.close();
    }
}
