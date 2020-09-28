package cn.itcast.demo03_test;

import java.io.File;
import java.io.FileFilter;

/*
    搜索 D:\aaa 目录中的 .java 文件

    使用过滤器完成对指定文件的过滤

 */
public class Demo03FileFilterTest {
    public static void main(String[] args) {
        //创建一个File对象表示d:\aaa这个文件夹
        File file = new File("d:\\aaa");
        printDirInner(file);
    }

    public static void printDir(File file) {
        //调用listFiles方法，传递一个过滤器
        File[] files = file.listFiles(new MyJavaFileFilter());
        //遍历这个数组
        for(File thisFile : files) {
            //判断，如果是一个文件夹，就继续递归遍历搜索这个文件夹中的.java文件
            if(thisFile.isDirectory()) {
                printDir(thisFile);
            } else {
                //如果是文件，就直接打印
                System.out.println(thisFile.getAbsolutePath());
            }
        }
    }

    /*
        使用匿名内部类的方式完成过滤器
     */
    public static void printDirInner(File file) {
        //调用listFiles方法，传递一个过滤器
        File[] files = file.listFiles(new FileFilter() {
            //accept方法中定义过滤器的规则
            @Override
            public boolean accept(File pathname) {
                if(pathname.isFile() && pathname.getName().endsWith(".java")) {
                    return true;
                }
                if(pathname.isDirectory()) {
                    return true;
                }
                return false;
            }
        });
        //遍历这个数组
        for(File thisFile : files) {
            //判断，如果是一个文件夹，就继续递归遍历搜索这个文件夹中的.java文件
            if(thisFile.isDirectory()) {
                printDir(thisFile);
            } else {
                //如果是文件，就直接打印
                System.out.println(thisFile.getAbsolutePath());
            }
        }
    }

    /*
        使用Lambda表示完成练习
     */
    public static void printDirLambda(File file) {
        //调用listFiles方法，传递一个过滤器
        File[] files = file.listFiles(pathname -> {
            if(pathname.isFile() && pathname.getName().endsWith(".java")) {
                return true;
            }
            if(pathname.isDirectory()) {
                return true;
            }
            return false;
        });
        //遍历这个数组
        for(File thisFile : files) {
            //判断，如果是一个文件夹，就继续递归遍历搜索这个文件夹中的.java文件
            if(thisFile.isDirectory()) {
                printDir(thisFile);
            } else {
                //如果是文件，就直接打印
                System.out.println(thisFile.getAbsolutePath());
            }
        }
    }
}
