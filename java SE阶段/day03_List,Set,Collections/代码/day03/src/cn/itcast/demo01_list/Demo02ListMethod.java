package cn.itcast.demo01_list;

import java.util.ArrayList;
import java.util.List;

/*
    List 接口中的方法：
    public void add(int index, E element) : 将指定的元素，添加到该集合中的指定位置上。
    （最常用）public E get(int index) :返回集合中指定位置的元素。
    public E remove(int index) : 移除列表中指定位置的元素, 返回的是被移除的元素。
    public E set(int index, E element) :用指定元素替换集合中指定位置的元素,返回值的更新前的元素
 */
public class Demo02ListMethod {
    public static void main(String[] args) {
        method4();
    }

    //public E set(int index, E element) :用指定元素替换集合中指定位置的元素,返回值的更新前的元素
    //参数index： 表示要替换这个位置的元素
    //参数element： 表示使用这个元素进行替换
    //返回值： 是被替换掉的元素。
    public static void method4() {
        //创建一个集合
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("爱迪生");
        list.add("达尔文");
        list.add("达芬奇");

        //打印集合
        System.out.println("list:" + list); //[爱迪生, 达尔文, 达芬奇]

        //把索引为1的元素替换成 居里夫人.
        String str = list.set(1, "居里夫人");

        System.out.println("list:" + list); //[爱迪生, 居里夫人, 达芬奇]
        System.out.println("str:" + str); //达尔文

    }

    //public E remove(int index)： 删除index位置上的元素，并返回被删除的元素
    public static void method3() {
        //创建一个集合
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("爱迪生");
        list.add("达尔文");
        list.add("达芬奇");
        System.out.println("list:" + list);
        //删除索引为1的元素
        String str = list.remove(1);
        System.out.println("list:" + list); //[爱迪生, 达芬奇]
        System.out.println("str:" + str); //[达尔文]

    }

    //public E get(int index) :返回集合中指定位置的元素。
    public static void method2() {
        //创建一个集合
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("爱迪生");
        list.add("达尔文");
        list.add("达芬奇");
        //直接根据索引获取元素
        System.out.println(list.get(2));
    }

    //public void add(int index, E element) : 将指定的元素，添加到该集合中的指定位置上。
    //参数index 是要添加的索引位置
    //参数element： 是要添加的元素
    public static void method1() {
        //创建一个集合
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("爱迪生");
        list.add("达尔文");
        list.add("达芬奇");
        System.out.println("list: " + list); //[爱迪生, 达尔文, 达芬奇]

        //往指定位置添加元素
        //往索引为1的位置添加哥白尼
        list.add(1, "哥白尼");
        //继续打印
        System.out.println("list: " + list); //[爱迪生, 哥白尼, 达尔文, 达芬奇]
    }
}
