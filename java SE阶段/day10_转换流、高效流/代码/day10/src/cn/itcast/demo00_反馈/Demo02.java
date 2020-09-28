package cn.itcast.demo00_反馈;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

//void store​(Writer writer, String comments)
public class Demo02 {
    public static void main(String[] args) throws IOException {
        //创建Properties集合
        Properties p = new Properties();
        p.setProperty("it001", "jack");
        p.setProperty("it002", "rose");
        p.setProperty("it003", "tony");

        //创建一个字符输出流
        FileWriter fw = new FileWriter("config.properties");

        p.store(fw, "I have a dream");

        fw.close();
    }
}
