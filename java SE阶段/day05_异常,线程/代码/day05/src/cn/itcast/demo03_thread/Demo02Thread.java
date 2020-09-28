package cn.itcast.demo03_thread;
/*
    在java中有一个类表示线程，这个类叫做Thread，可以使用这个类去实现多线程程序。

    多线程的实现步骤：
        1. 定义一个类，继承Thread
        2. 使用这个类重写run方法。 在run方法中定义线程要执行的任务。
        3. 在测试类中创建Thread子类对象。
        4. 调用start方法，启动该线程。

    调用线程的start方法后会做两件事情。
        1. 让这个线程启动。
        2. JVM会让这个线程执行自己的run方法。



 */
public class Demo02Thread {
    public static void main(String[] args) {
        System.out.println("main...start...");
        //测试类中创建Thread子类对象。
        //创建新的线程，只不过这个线程创建出来之后没有启动。
        MyThread mt = new MyThread();

        //调用start方法，启动该线程。
        mt.start();// 1. 会让这个线程启动。 2. 会执行这个线程的run方法。

        //打印100行hello world
        for(int i = 1; i <= 1000; i++) {
            System.out.println("hello...world:" + i);
        }

        System.out.println("main...end...");
    }
}
