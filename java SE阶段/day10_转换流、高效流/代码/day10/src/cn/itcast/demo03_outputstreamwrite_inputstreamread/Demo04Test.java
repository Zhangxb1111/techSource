package cn.itcast.demo03_outputstreamwrite_inputstreamread;

import java.io.*;

/*
    将gbk格式的文件转成utf-8格式。

    思路：
        1. 读取gbk格式的文件。
        2. 把读取出来的数据以utf-8编码写入新的文件。
 */
public class Demo04Test {
    public static void main(String[] args) throws IOException {
        //创建InputStreamReader，指定gbk进行读取
        InputStreamReader isr = new InputStreamReader(new FileInputStream("d:\\file05-gbk.txt"), "gbk");
        //创建OutputStreamWriter，指定utf-8进行写入
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:\\file06-utf8.txt"), "utf-8");

        //一边读，一边写。
        int i;
        while((i = isr.read()) != -1) {
            //把读取到的数据写到新的文件
            osw.write(i);
        }

        osw.close();
        isr.close();
    }
}
