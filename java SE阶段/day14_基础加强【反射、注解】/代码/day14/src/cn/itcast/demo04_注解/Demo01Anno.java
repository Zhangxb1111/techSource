package cn.itcast.demo04_注解;
/*
    注解： @XXX @Override @FunctionalInterface

    1. 注解是从jdk1.5出的特性
    2. 注解可以放在类上，方法上，或者字段上....
    3. 注解可以完成某些功能。

    注解和注释的区别：
        注释： 是给程序员看的，注释不会影响程序的执行。
        注解： 是给程序看的，程序可以根据注解完成一些功能， 注解会影响到程序的执行。


    常见的注解
        @Override： 验证一个方法是否是重写的父类的方法
        @FunctionalInterface： 验证一个接口是否是函数式接口
        @SuppressWarnings： 抑制警告
        @Deprecated：标记已经过时
 */
public class Demo01Anno {
    public static void main(String[] args) {
        method();
    }

    @Deprecated
    public static void method() {
        System.out.println("method");
    }
}
