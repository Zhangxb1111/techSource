package cn.itcast.demo03_reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    使用字符输出流一次读取一个字符数组

    int read​(char[] cbuf)：一次读取一个字符数组。 这个方法会把读取到的数据放入到字符数组中。并返回读取到的有效个数，如果读取结束，返回-1


 */
public class Demo02Reader {
    public static void main(String[] args) throws IOException {
        //创建一个字符输入流对象
        FileReader fr = new FileReader("source03.txt");

        //开始读取，一次读取一个字符数组。
        char[] cArr = new char[1024];//定义的字符数组，用来保存每次读取到的数据
        int len; //定义变量，用来保存每次读取到的长度

        //开始while循环读取
        while ((len = fr.read(cArr)) != -1) {
            /*
                循环条件做的事情
                1. 通过字符输入流调用read方法，将数据读取到cArr这个字符数组中
                2. 将读取到的个数返回，并且赋值给变量len
                3. 判断len是否不等于-1，如果不是-1表示读取到了内容，就在循环中进行处理。
             */
            System.out.print(new String(cArr, 0, len));
        }

        //释放资源
        fr.close();
    }
}
