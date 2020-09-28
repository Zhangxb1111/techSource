package cn.itcast.demo03_test;

import java.io.File;

/*
    搜索 D:\aaa 目录中的 .java 文件
 */
public class Demo01Test {
    public static void main(String[] args) {
        printDir(new File("d:\\aaa"));
    }

    /*
        定义方法，用来打印目录中指定的文件
        参数：是要打印哪个目录

        步骤：
            1. 获取这个目录下面的所有的文件和文件夹，得到对应的数组
            2. 遍历这个数组，拿到每一个文件或文件夹。
            3. 判断如果遍历到的是文件夹，那么继续递归调用遍历这个文件夹。
               如果遍历到的是一个文件，那么就判断这个文件是否以.java结尾并打印
     */
    public static void printDir(File dir) {
        //1. 获取这个目录下面的所有的文件和文件夹，得到对应的数组
        File[] files = dir.listFiles();
        //2. 遍历这个数组，拿到每一个文件或文件夹。
        for(File thisFile : files) {
            //判断如果遍历到的是文件夹，那么继续递归调用遍历这个文件夹。
            if(thisFile.isDirectory()) {
                printDir(thisFile);
            } else {
                //如果遍历到的是一个文件，那么就判断这个文件是否以.java结尾并打印
                if(thisFile.getName().endsWith(".java")) {
                    //打印对应的绝对路径
                    System.out.println(thisFile.getAbsolutePath());
                }
            }
        }
    }
}
