package cn.itcast.demo03_reader;

import javax.annotation.processing.Filer;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    在java中Reader是字符输入流，可以将文件中的数据读取到java程序中。
    Reader是字符输入流的顶层父类，是一个抽象类。 如果要用，需要使用子类。
    最常用的子类叫做FileReader。
    字符输入流可以以字符为单位进行读取，这样就可以读取中文了。

    FileReader的构造方法：
        FileReader​(File file)： 传递一个File类型的文件
        FileReader​(String fileName)： 传递一个String类型的文件路径

    FileReader里面的其他方法:
        int read​()： 一次读取一个字符。返回值为读取到字符。如果读取结束返回-1
        int read​(char[] cbuf)：一次读取一个字符数组。

    读取的步骤：
        １.　创建一个FileReader对象，绑定一个目的地
         2. 调用read方法进行读取。
        3.  释放资源
 */
public class Demo01Reader {
    public static void main(String[] args) throws IOException {
        //创建FileReader对象
        FileReader fr = new FileReader("source03.txt");

        //开始读取，一次读取一个字符数组
        //int read​()： 一次读取一个字符
        int i;//定义变量，保存每次读取接收到的字符
        while ((i = fr.read()) != -1) {
            /*
                条件做的事情
                1. 使用字符输入流读取一个字符
                2. 把读取到的字符赋值给变量i
                3. 判断i是否不等于-1，如果不是-1表示读取到了数据，那么就在循环中处理
             */
            System.out.print((char) i);
        }

        //释放资源
        fr.close();
    }
}
