package cn.itcast.demo05_exception;

import javax.annotation.processing.Filer;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
    在jdk7之后，多了新的异常处理方式。 是另外一种try语句

    try(创建流对象) {
        使用这个流对象
    } catch(异常) {
        //捕获处理方式
    }

    不管程序的执行结果如何，都会调用在try中创建的流对象的close方法。
    注意：这个close方法，不需要我们手动去调用，系统会帮我们去调用

    try后面的小括号中也可以创建多个对象，多个对象之间使用分号隔开
 */
public class Demo02Exception {
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("file08.txt")) {
            //调用write方法，写数据
            fw.write("你好");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {

        }
    }
}
