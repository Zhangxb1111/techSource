package cn.itcast.demo01_thread;
/*
    多线程中的方法。

    Thread的构造方法
    Thread​(String name)： 传递一个线程的名字。

    Thread的其他方法
    String getName​()： 用来获取线程的名字。
    void setName​(String name)：设置线程的名字
    static Thread currentThread​()：获取当前正在运行的线程对象。
    static void sleep​(long millis)：线程休眠，参数是休眠多少毫秒
 */
public class Demo02ThreadMethod {
    public static void main(String[] args) {
        //创建Thread子类对象
        MyThreadMethod mtm = new MyThreadMethod("旺财");
        //mtm.setName("狗蛋");
        //调用start方法，开启线程
        mtm.start();

        //再创建一个新的线程并开启
        //new MyThreadMethod().start();
        //new MyThreadMethod().start();

        //获取到main线程的名字，并打印。

        //调用方法获取当前正在运行的线程对象
        //这个方法是通过哪个线程调用的，获取的就是哪个线程对象。
        Thread t = Thread.currentThread();
        //通过获取到的线程对象调用getName方法，获取线程名字
        System.out.println("mian线程的名字是：" + t.getName());
    }
}
