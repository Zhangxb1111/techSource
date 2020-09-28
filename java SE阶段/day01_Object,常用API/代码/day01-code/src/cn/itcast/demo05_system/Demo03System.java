package cn.itcast.demo05_system;

import java.util.Arrays;

/*
    System中有一个方法，可以对数组进行复制。
        static void arraycopy​(Object src, int srcPos, Object dest, int destPos, int length)： 将一个数组复制到另一个数组中
        参数src： 表示源数组。
        参数srcPos： 源数组的起始位置。
        参数dest： 表示目标数组。
        参数destPos： 目标数组的起始位置
        参数length： 表示复制元素的个数。

    练习：
        将src数组中前3个元素，复制到dest数组的前3个位置上
        复制元素前：src数组元素[1,2,3,4,5]，dest数组元素[6,7,8,9,10]
        复制元素后：src数组元素[1,2,3,4,5]，dest数组元素[1,2,3,9,10]
    就是把src中的前3个元素，复制到了dest数组中的前三个位置

    这个方法的复制是系统级别的，效率灰常高。。。
 */
public class Demo03System {
    public static void main(String[] args) {
        //创建两个数组
        int[] src = {1,2,3,4,5};
        int[] dest = {6,7,8,9,10};
        //进行复制，把src的前三个元素复制到dest的前三个位置上
        System.arraycopy(src, 0, dest, 0, 3);

        //System.arraycopy(src, 2, dest, 1, 3);

        //打印
        System.out.println("src:" + Arrays.toString(src));
        System.out.println("dest:" + Arrays.toString(dest));
    }
}
