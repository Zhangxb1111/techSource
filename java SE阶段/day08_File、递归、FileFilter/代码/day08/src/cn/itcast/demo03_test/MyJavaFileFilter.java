package cn.itcast.demo03_test;

import java.io.File;
import java.io.FileFilter;

public class MyJavaFileFilter implements FileFilter{
    //在accept方法中定义过滤的规则
    //把所有.java的文件留下
    @Override
    public boolean accept(File pathname) {
        if(pathname.isFile() && pathname.getName().endsWith(".java")) {
            return true;
        }

        //判断如果是文件夹，返回true
        if(pathname.isDirectory()) {
            return true;
        }
        return false;
    }
}
