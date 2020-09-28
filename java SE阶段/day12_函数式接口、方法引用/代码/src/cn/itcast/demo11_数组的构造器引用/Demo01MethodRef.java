package cn.itcast.demo11_数组的构造器引用;

import java.util.Arrays;

/*
    数组的构造器引用
        数据类型[]::new
 */
public class Demo01MethodRef {
    public static void main(String[] args) {
        //method(len -> new int[len]);

        method(int[]::new);
    }

    public static void method(ArrayBuilder arrayBuilder) {
        int[] arr = arrayBuilder.createArray(10);
        System.out.println(Arrays.toString(arr));
    }
}
