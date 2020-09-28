package cn.itcast.demo04_writer;

import java.io.FileWriter;
import java.io.IOException;

/*
    关闭方法和释放资源方法的区别

    flush()：仅仅是刷新操作。 流刷新之后还是可以使用的。
    close()：先刷新，然后再释放资源。  流关闭之后就不能使用了
 */
public class Demo02CloseAndFlush {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("file05.txt");

        //调用方法，写数据
        fw.write("你好");
        fw.flush();
        fw.write("我好");
        fw.flush();

        //直接释放资源
        fw.close();

        fw.write("大家好"); //java.io.IOException: Stream closed
    }
}
