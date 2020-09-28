package cn.itcast.demo02_digui;
/*
    递归

    递归指的是方法直接或者间接的调用方法本身。

    递归有两种调用方式
        1. 直接递归 A -> A
        2. 间接递归 A -> B -> C -> A


    递归的注意事项：
        1. 递归一定要有结束的条件，不然会内存溢出。
        2. 递归的次数不能太多，否则也会内存溢出.

    内存溢出： 内存不够用了
    内存泄漏： 有些对象没有用了，但是没有办法回收掉。

    内存泄漏会导致内存溢出。
 */
public class Demo01DiGui {
    public static void main(String[] args) {
        printNumber(1);
    }

    //使用递归依次打印1 2 3 4 5 .....
    public static void printNumber(int num) {
        if(num == 5000) {
            return;
        }
        System.out.println(num);
        num++;
        printNumber(num);
    }


    public static void methodC() {
        System.out.println("methodC...");
        methodA();
    }

    public static void methodB() {
        System.out.println("methodB...");
        methodC();
    }

    public static void methodA() {
        System.out.println("methodA...");
        methodB();
    }

    public static void method() {
        System.out.println("method...");
        method();
    }
}
