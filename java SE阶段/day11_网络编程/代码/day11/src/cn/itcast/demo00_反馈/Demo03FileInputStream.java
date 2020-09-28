package cn.itcast.demo00_反馈;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/*
    while(条件) {
        循环体;
    }
    1. 条件
    2. 循环体
 */
public class Demo03FileInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("aa.txt");

        int i;
        while((i = fis.read()) != -1) {
            System.out.println(i);
        }

        fis.close();
    }
}
