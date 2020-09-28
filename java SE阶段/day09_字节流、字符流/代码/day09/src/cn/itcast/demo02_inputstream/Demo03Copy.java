package cn.itcast.demo02_inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    文件复制。

    文件复制其实就是一边读，一边写，每读取一次就把读取到的内容写到文件中。
    为了保证复制效率，我们采用一次读取一个字节数组的方式进行复制

    思路：
        1. 创建字节输入流对象，用来读取
        2. 创建字节输出流对象，用来写入。
        3. 开始读取，一次读取一个字节数组。
        4. 把读取到的字节数组的内容写入到目的地文件
        5. 循环 第3步 和 第4步
        6. 释放资源
 */
public class Demo03Copy {
    public static void main(String[] args) throws IOException {
        //1. 创建字节输入流对象，用来读取
        FileInputStream fis = new FileInputStream("aa.jpg");
        //2. 创建字节输出流对象，用来写入。
        FileOutputStream fos = new FileOutputStream("bb.jpg");
        //3. 开始读取，一次读取一个字节数组。
        byte[] bArr = new byte[1024 * 8];//用来存储读取到的数据
        int len;//用来存储读取到的长度
        while((len = fis.read(bArr)) != -1) {
            //4. 每读取到一个内容，就把读取到的内容写入到目的地文件
            fos.write(bArr, 0, len);
        }

        fos.close();
        fis.close();
    }
}
