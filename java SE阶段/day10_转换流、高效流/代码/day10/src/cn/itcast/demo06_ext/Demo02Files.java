package cn.itcast.demo06_ext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.util.List;

/*
    jdk7之后，提供了一个NIO的工具类，叫做Files

    相关API：
        Path： 表示一个路径。
        Paths： 路径的工具类，可以获取一个Path对象
        Files： 操作IO的工具类

    Paths中有一个方法，可以获取到一个Path对象
        static Path get​(String first, String... more)： 根据多个路径片段组合成一个path对象

    Files中的方法：
        static Path copy​(Path source, Path target, CopyOption... options) ：复制
        参数source：源文件
        参数target：目标文件
        参数options： 以什么方式复制。 可以传递REPLACE_EXISTING。 表示如果文件存在就替换

        static List<String> readAllLines​(Path path):读取文件中的所有的行，并且保存在集合中
 */
public class Demo02Files {
    public static void main(String[] args) throws IOException {
        method2();
    }
    // static List<String> readAllLines​(Path path):读取文件中的所有的行，并且保存在集合中
    public static void method2() throws IOException {
        List<String> list = Files.readAllLines(Paths.get("outTeacherTable.txt"));
        for (String s : list) {
            System.out.println(s);
        }
    }

    //对文件的复制
    public static void method1() throws IOException {
        Path source = Paths.get("d:", "aa.jpg");
        Path dest = Paths.get("e:", "bb.jpg");
        //调用Files的copy进行复制
        Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
    }
}
