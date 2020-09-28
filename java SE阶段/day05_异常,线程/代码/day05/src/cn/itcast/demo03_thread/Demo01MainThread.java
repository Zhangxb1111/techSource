package cn.itcast.demo03_thread;
/*
    每个程序里面至少要有一个线程。
    我们之前运行的java程序也是有线程的。
    当运行main方法的时候jvm会启动， 并且JVM会创建一个新线程这个线程叫做main线程，由这个main线程去执行mian方法中的代码。

    单线程程序同时只能执行一个任务，如果有多个任务，只能执行完其中一个之后再去执行另外一个任务。

    如果想要同时执行多个任务，可以使用多线程
    在java中Thread类表示线程类，可以使用这个类实现多线程程序。

 */
public class Demo01MainThread {
    public static void main(String[] args) {
        System.out.println("main...start");
        //打印100行hello...java
        for(int i = 1; i <= 100; i++) {
            System.out.println("hello...java:" + i);
        }

        // 打印100行hello...world
        for(int i = 1; i <= 100; i++) {
            System.out.println("hello...world:" + i);
        }

        System.out.println("main...end");
    }
}
