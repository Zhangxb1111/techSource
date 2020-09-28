package cn.itcast.demo02_inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/*
    使用字节输入流一次读取一个字节数组。

    int read​(byte[] b)： 一次读取一个字节数组，输入流会把读取到的内容放入到这个字节数组中，并返回读取到的个数， 如果读取结束返回-1.


    这种读取方式效率高
 */
public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        //创建一个FileInputStream对象
        FileInputStream fis = new FileInputStream("source02.txt");
        //调用read方法读取数据.
        // int read​(byte[] b)： 一次读取一个字节数组
        //会将数据读取到字节数组里面。 字节数组长度是几，那么就最多一次读取几个。 并且返回读取到的个数，读取结束，返回-1

        //使用循环，一次读取一个字节数组
        //定义一个字节数组，用来保存读取到的数据。
        byte[] bArr = new byte[2];
        //定义一个变量，用来保存读取到的个数
        int len;
        //使用循环开始读取
        while ((len = fis.read(bArr)) != -1) {
            /*
                上面条件作了下面的事情：
                1. 通过字节输入流fis调用read方法，将数据读取到bArr这个字节数组中
                2. 将读取到的有效个数返回，赋值给len。
                3. 判断len是否不等于-1，如果不等于-1，表示读取到了内容，就就在循环中进行处理.
                读取出来的数组在bArr数组中放着
             */
            //最后一次读取可能会有上次残留的数据，所以不能把字节数组的整体都转成String
            //System.out.println(new String(bArr));

            //读取到了几个内容，就把字节数组的几个元素转成字符串，并且打印
            System.out.print(new String(bArr, 0, len));
        }

        /*
        byte[] bArr = new byte[2];
        int len = fis.read(bArr);
        System.out.println(new String(bArr, 0, len));//
        System.out.println(len);//2

        //接着读
        len = fis.read(bArr);
        System.out.println(new String(bArr, 0, len));//
        System.out.println(len);//2

        len = fis.read(bArr);
        System.out.println(new String(bArr, 0, len));//
        System.out.println(len);//1

        len = fis.read(bArr);
        System.out.println(new String(bArr));//[101, 100]
        System.out.println(len);//-1
        */
        //释放资源
        fis.close();
    }
}
