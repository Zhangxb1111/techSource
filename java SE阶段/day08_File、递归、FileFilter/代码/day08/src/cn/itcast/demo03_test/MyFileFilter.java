package cn.itcast.demo03_test;

import java.io.File;
import java.io.FileFilter;

/*
    此时这个类实现了FileFilter接口，就表示这个类是一个过滤器了。
 */
public class MyFileFilter implements FileFilter{

    //accept方法中要定义过滤的规则。
    //参数pathname表示的是指定目录下的每个File对象
    //返回值如果是true表示这个File对象是留下的，如果是false表示这个File对象要过滤掉
    @Override
    public boolean accept(File pathname) {
        //希望所有的.txt文件留下
        if(pathname.getName().endsWith(".txt")) {
            return true;
        }
        return false;
    }
}
