package cn.itcast.demo03_foreach;

import java.util.Arrays;

/*
    在jak1.5之后，多了一个新的遍历方式，叫做增强for遍历（foreach）

    格式：
        for(数据类型 变量名 : 容器) {
            //...
        }
    格式解释：
        数据类型： 容器中保存的元素是什么类型，这个数据类型就是什么。
        变量名： 表示的是容器中的每个元素。
        容器： 是集合或者数组。 JDK规定，实现Iterable接口，就可以允许称为增强for的目标。

    增强for遍历数组，只是一个语法糖。 本质就是普通for循环。
 */
public class Demo01Foreach {
    public static void main(String[] args) {
        //创建一个数组
        int[] intArr = {11, 22, 33, 44, 55};
        //使用普通for遍历这个数组
        for(int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
        System.out.println("----------------------");
        //使用增强for遍历这个数组
        for(int num : intArr) {
            System.out.println(num);//num表示的是数组中的每一个元素。 而不是索引。
        }

        System.out.println("----------------------");
        //创建一个double数组
        double[] doubleArr = {10.1, 20.2, 30.3, 40.4, 50.5};
        //使用增强for遍历这个数组
        for(double num : doubleArr) {
            System.out.println(num);//num表示的是数组中的每一个元素
        }

        System.out.println("----------------------");
        int[] arr = {10, 20, 30, 40, 50};
        for(int num : arr) {
            num += 2;
        }

        //进行打印
        System.out.println(Arrays.toString(arr));
    }
}
