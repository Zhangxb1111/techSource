package cn.itcast.demo01_list;

import java.util.LinkedList;
import java.util.List;

/*
    LinkedList中有很多独有的方法，用于对集合的首尾进行操作。

    void addFirst​(E e)： 向集合首个位置添加元素
    void addLast​(E e)： 向集合的尾部添加元素
    E getFirst​()： 获取首个元素
    E getLast​()： 获取尾部元素
    E removeFirst​()： 删除首个元素，并且返回被删除的元素。
    E removeLast​()： 删除尾部元素，并且返回被删除的元素
    void push​(E e)：压入。 在首个位置添加元素
    E pop​()：弹出，删除第一个元素
 */
public class Demo05LinkedListMethod {

    public static void main(String[] args) {
        method4();
    }

    /*
        void push​(E e)：压入。 在首个位置添加元素
        E pop​()：弹出，删除第一个元素
     */
    public static void method4() {
        //创建LinkedList集合
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("诸葛亮");
        list.add("周瑜");
        list.add("王朗");
        //打印集合
        System.out.println("list:" + list); //[诸葛亮, 周瑜, 王朗]
        //void push​(E e)：压入。 在首个位置添加元素
        list.push("刘备");
        System.out.println("list:" + list); //[刘备, 诸葛亮, 周瑜, 王朗]
        // E pop​()：弹出，删除第一个元素。并且会把这个元素返回
        String first = list.pop();
        System.out.println("list:" + list); //[诸葛亮, 周瑜, 王朗]
        System.out.println("first:" + first); //刘备

    }
    /*
        E removeFirst​()： 删除首个元素，并且返回被删除的元素。
        E removeLast​()： 删除尾部元素，并且返回被删除的元素
     */
    public static void method3() {
        //创建LinkedList集合
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("诸葛亮");
        list.add("周瑜");
        list.add("王朗");
        System.out.println("list:" + list); //[诸葛亮, 周瑜, 王朗]

        //String first = list.removeFirst();
        //System.out.println("list:" + list); // [周瑜, 王朗]
        //System.out.println("first:" + first); //诸葛亮

        String last = list.removeLast();
        System.out.println("list:" + list); //[诸葛亮, 周瑜]
        System.out.println("last:" + last); //王朗
    }
    /*
        E getFirst​()： 获取首个元素
        E getLast​()： 获取尾部元素
     */
    public static void method2() {
        //创建LinkedList集合
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("诸葛亮");
        list.add("周瑜");
        list.add("王朗");
        System.out.println("list:" + list); //[诸葛亮, 周瑜, 王朗]
        //E getFirst​()： 获取首个元素
        System.out.println("获取的首个元素是：" + list.getFirst()); // 诸葛亮
        //E getLast​()： 获取尾部元素
        System.out.println("获取的尾部元素是：" + list.getLast()); //王朗
    }

    /*
        void addFirst​(E e)： 向集合首个位置添加元素
        void addLast​(E e)： 向集合的尾部添加元素
     */
    public static void method1() {
        //创建LinkedList集合
        LinkedList<String> list = new LinkedList<>();
        //添加元素
        list.add("诸葛亮");
        list.add("周瑜");
        list.add("王朗");
        //打印
        System.out.println("list:" + list); //[诸葛亮, 周瑜, 王朗]
        //void addFirst​(E e)： 向集合首个位置添加元素
        list.addFirst("刘备");
        System.out.println("list:" + list); //[刘备, 诸葛亮, 周瑜, 王朗]
        //void addLast​(E e)： 向集合的尾部添加元素
        list.addLast("关羽");
        System.out.println("list:" + list); //[刘备, 诸葛亮, 周瑜, 王朗, 关羽]
    }
}
