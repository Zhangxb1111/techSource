package cn.itcast.demo02_digui;

import java.io.File;

/*
    使用递归打印文件夹

    如果层级不确定，使用递归，比如遍历打印文件夹。
 */
public class Demo04PrintDir {
    public static void main(String[] args) {
        printDir(new File("d:\\明星"));
    }

    /*
        定义方法，打印文件夹
        参数： 表示要遍历哪一个文件夹
     */
    public static void printDir(File dir) {
        //获取这个文件夹下面所有的文件和文件夹
        File files[] = dir.listFiles();
        //遍历这个数组，拿到里面的每个内容进行打印
        for(File thisFile : files) {
            //如果遍历到的是文件夹，应该进入到这个文件夹里面去（获取这个文件夹下面的所有的内容并打印）
            if(thisFile.isDirectory()) {
                //如果是文件夹，就获取到这个文件夹下面的所有内容并打印
                printDir(thisFile);
            } else {
                //否则这是一个文件。是文件就直接打印
                System.out.println(thisFile.getName());
            }
        }
    }

    public static void printDir2(File dir) {
        File[] files2 = dir.listFiles();
        for(File thisFile2 : files2) {
            //如果thisFile是文件夹，那么就获取到这个文件夹下面的内容进行遍历
            //如果thisFile表示的是一个文件，那么就直接打印这个文件的名字。
            if(thisFile2.isDirectory()) {
                printDir3(thisFile2);
            } else {
                //如果是一个文件，就直接打印打印名字
                System.out.println(thisFile2.getName());
            }
        }
    }

    public static void printDir3(File dir) {

        //获取到这个文件夹下面的内容进行遍历
        File[] files3 = dir.listFiles();
        //遍历这个数组
        for(File thisFile3 : files3) {
            System.out.println(thisFile3.getName());
        }

    }
}
