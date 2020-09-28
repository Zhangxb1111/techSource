package cn.itcast.demo01_bufferedstream;

import java.io.*;

/*
    使用缓冲流一次读写一个字节数组的方式复制文件

    10ms
 */
public class Demo03BufferedStream {
    public static void main(String[] args) throws IOException {
        //创建字节输出缓冲流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("cc.jpg"));
        //创建字节输入缓冲流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("aa.jpg"));

        long start = System.currentTimeMillis();

        //开始复制，一次读写一个字节数组
        byte[] bArr = new byte[1024 * 8];
        int len;
        while((len = bis.read(bArr)) != -1) {
            bos.write(bArr, 0, len);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

        //释放资源
        bis.close();
        bos.close();
    }
}
