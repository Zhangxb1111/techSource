package cn.itcast.demo04_writer;

import java.io.FileWriter;
import java.io.IOException;

/*
    FileWriter 中其他写入的方法。

    void write​(char[] cbuf)： 向文件中写入字符数组
    void write​(char[] cbuf, int off, int len) : 向文件中写入字符数组的一部分。off表示其实位置。 len表示个数
    void write​(int c)：向文件中写入一个字符.
    void write​(String str)：向文件中写入一个字符串
    void write​(String str, int off, int len)： 向文件中写入一个字符串的一部分
 */
public class Demo03WriterMethod {
    public static void main(String[] args) throws IOException {
        //创建一个FileWriter对象
        FileWriter fw = new FileWriter("file06.txt");
        //void write​(char[] cbuf)： 向文件中写入字符数组
        char[] cArr = {'h', 'e', 'l', 'l', 'o'};
        //fw.write(cArr);

        //void write​(char[] cbuf, int off, int len) : 向文件中写入字符数组的一部分
        //fw.write(cArr, 1, 3);//将cArr这个字符数组写入到文件，从索引为1的位置开始写，写3个.

        //void write​(int c)：向文件中写入一个字符.
        //fw.write(100); //d
        //fw.write('a');
        //fw.write('中');

        //void write​(String str)：向文件中写入一个字符串
        //fw.write("你好啊");

        //void write​(String str, int off, int len)： 向文件中写入一个字符串的一部分
        fw.write("hello", 1, 3); // ell

        //刷新
        fw.flush();
        //释放资源
        fw.close();
    }
}
