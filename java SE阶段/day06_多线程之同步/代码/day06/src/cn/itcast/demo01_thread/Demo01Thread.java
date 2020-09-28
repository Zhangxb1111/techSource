package cn.itcast.demo01_thread;
/*
    多线程的实现方式。

    步骤：
        1. 定义一个类，然后继承Thread
        2. 重写里面的run方法，在run方法中定义线程要执行的任务
        3. 在测试类中创建子类的对象。
        4. 调用start方法，开启线程。
 */
public class Demo01Thread {
    public static void main(String[] args) {
        System.out.println("main...start");
        //创建线程
        MyThread mt = new MyThread();

        //调用start方法，让这个线程开始执行
        //这个线程会执行自己的run方法
        mt.start();
        System.out.println("main...end");
    }
}
