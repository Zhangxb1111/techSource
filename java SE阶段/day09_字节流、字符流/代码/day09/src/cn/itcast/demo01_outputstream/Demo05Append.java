package cn.itcast.demo01_outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/*
    如果想要在原来文件的后面进行续写，可以使用另外的构造方法创建对象。


    FileOutputStream​(File file, boolean append)： 第二个参数append表示是否要续写。true表示续写。
    FileOutputStream​(String name, boolean append)： 第二个参数append表示是否要续写。true表示续写。
 */
public class Demo05Append {
    public static void main(String[] args) throws IOException {
        //创建一个字节输出流对象，绑定一个目的地
        FileOutputStream fos = new FileOutputStream("file02.txt", true);

        //调用write方法，向文件中写入一个字节数组
        fos.write("疑是地上霜".getBytes());

        //释放资源
        fos.close();
    }
}
