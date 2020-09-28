package cn.itcast.demo03_outputstreamwrite_inputstreamread;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    使用FileReader读取文件中的内容

    FileReader读取的时候，会使用idea平台默认编码方式去读取，而平台默认的编码是UTF-8
    但是我们要读取的文件采用的是gbk编码，此时编码不一致，就产生了乱码。


    我们可以想办法指定编码进行读写， 指定编码就可以使用转换流
 */
public class Demo01FileReader {
    public static void main(String[] args) throws IOException {
        //创建一个FileReader对象
        FileReader fr = new FileReader("d:\\aa.txt");
        //开始读取。
        int i;
        while((i = fr.read()) != -1) {
            System.out.print((char)i);
        }

        //释放资源
        fr.close();
    }
}
