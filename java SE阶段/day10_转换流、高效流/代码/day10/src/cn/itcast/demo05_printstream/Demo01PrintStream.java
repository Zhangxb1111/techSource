package cn.itcast.demo05_printstream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
    打印流

    打印流我们一直在用，System中的out成员就是一个打印流，这个一般称为标准输出流，输出的目的地是控制台。

    打印流可以更加方便的完成输出操作。
    打印流只有输出，没有输入。

    在java中打印流有两个，一个是字节打印流，一个是字符打印流。
    字节打印流：PrintStream
    字符打印流：PrintWriter

    PrintStream的构造方法：
        PrintStream​(File file)：传递File类型的文件
        PrintStream​(OutputStream out)： 传递一个字节输出流
        PrintStream​(String fileName)： 传递一个字符串类型的文件路径

    PrintStream的写的方法。
        write...
        print... 输出
        println... 输出并换行

        如果调用write方法和print方法传递数字，那么write方法是查询ASCII输出。而print是原样输出。


    System.out是标准输出流，输出的目的地是控制台。
    我们可以对这个目的地进行改变。

    调用System的setOut方法可以对这个目的地进行改变

 */
public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        //创建一个PrintStream对象
        PrintStream ps = new PrintStream("file07.txt");
        //调用方法写入
        //ps.write(100);

        ps.print(100);
        ps.print(200);

        //ps.close();
        System.setOut(ps);  //把标准输出流的目的地给改变了，此时标准输出流的目的地是ps所指向的位置

        System.out.println("你好");
        System.out.println("我好");
        System.out.println("大家好");
    }
}
