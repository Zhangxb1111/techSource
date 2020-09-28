package cn.itcast.demo05_exception;

import java.io.FileWriter;
import java.io.IOException;
/*
    了解
    JDK9释放资源
 */
public class Demo04Exception {
    public static void main(String[] args) throws IOException {
        //创建一个FileWriter对象
        FileWriter fw = new FileWriter("file09.txt");

        try(fw) {
            fw.write("你好");
        }catch (IOException e) {

        }
    }
}
