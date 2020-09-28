package cn.itcast.demo01_outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    换行写

    如果要实现换行，可以使用换行符。
    每个操作系统的换行符都不一样。
    windows： \r\n
    linux： \n
    mac： \r
 */
public class Demo06WriteLine {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("file03.txt");
        //调用方法，向文件中写数据
        fos.write("苟利国家生死以\r\n".getBytes());
        fos.write("岂因祸福避趋之".getBytes());

        fos.close();
    }
}
