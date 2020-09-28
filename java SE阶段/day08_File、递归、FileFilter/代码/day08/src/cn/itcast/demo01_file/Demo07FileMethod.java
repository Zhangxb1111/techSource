package cn.itcast.demo01_file;

import java.io.File;

/*
    File里面的删除功能

    boolean delete​()： 删除File对象所表示的文件或者文件夹

    如果调用delete删除的是文件夹，那么这个文件夹中不能有东西。
    因为delete方法只能删除空文件夹。

    【注意： 调用delete删除之后的内容不走回收站】
    【注意： 调用delete删除之后的内容不走回收站】
    【注意： 调用delete删除之后的内容不走回收站】
    【注意： 调用delete删除之后的内容不走回收站】
    【注意： 调用delete删除之后的内容不走回收站】
    【注意： 调用delete删除之后的内容不走回收站】
    【注意： 调用delete删除之后的内容不走回收站】
    【注意： 调用delete删除之后的内容不走回收站】
    【注意： 调用delete删除之后的内容不走回收站】
    【注意： 调用delete删除之后的内容不走回收站】

 */
public class Demo07FileMethod {
    public static void main(String[] args) {
        //创建一个File对象
        //File file = new File("d:\\iotest\\aa.txt");
        //File file = new File("d:\\iotest\\bb");
        File file = new File("d:\\iotest");

        //调用delete方法，删除对应的文件或者文件夹
        boolean flag = file.delete();
        System.out.println("flag:" + flag);
    }
}
