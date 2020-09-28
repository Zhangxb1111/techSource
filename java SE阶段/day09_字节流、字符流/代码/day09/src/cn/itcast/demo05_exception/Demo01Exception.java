package cn.itcast.demo05_exception;

import java.io.FileWriter;
import java.io.IOException;

/*
    在JDK7之前的IO流中的异常处理

    一定要保证释放资源的代码无论如何都会执行到。
    我们可以把这部分代码放入到finally代码块中
 */
public class Demo01Exception {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            //创建一个FileWriter对象
            fw = new FileWriter("file07.txt");
            //调用write方法，写数据
            fw.write("你好");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                //如果fw输出流创建对象的时候出问题了，或者创建对象之前出问题了。那么这个流是不需要关。
                //如果创建之前出问题了，fw的值是null
                if(fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
