package cn.itcast.demo06_stringbuilder;
/*
    StringBuilder是一个可变的字符序列（可以改变的字符串）

    StringBuilder内部是使用一个数组去存储数据的
    在JDK9之前：是char[]
    在JDK9及之后： 是byte[]

    StringBuilder和String的区别
    String是不可变的。
    StringBuilder是可以改变的。

    如果要进行频繁的拼接，使用StringBuilder效率是要比String 高的

    构造方法：
        StringBuilder​(): 空参数构造。
        StringBuilder​(String str)： 根据指定的字符串创建一个StringBuilder对象。
 */
public class Demo02StringBuilder {
    public static void main(String[] args) {
        //使用空参数构造创建一个对象
        StringBuilder sb1 = new StringBuilder();
        System.out.println("sb1:" + sb1);

        //使用一个参数是字符串的构造方法创建一个对象
        StringBuilder sb2 = new StringBuilder("今天早上你洗头了吗");
        System.out.println("sb2:" + sb2);
    }
}
