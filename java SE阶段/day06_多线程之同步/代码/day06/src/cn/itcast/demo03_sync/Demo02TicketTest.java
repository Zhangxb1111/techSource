package cn.itcast.demo03_sync;
/*
    如果要解决线程安全问题，那么可以使用synchronize关键字。
    synchronized这个关键字表示同步， 可以修饰代码块，也可以修饰方法。

    如果synchronize修饰代码块，那么这个就叫做同步代码块

    格式：
        synchronized(锁对象) {
            要同步的代码;
        }

    锁对象就是一个普通的java对象，可以是任意的一个对象。
    锁对象只是做一个标记。

    同步代码块的作用：
        只有持有锁对象的线程才能够进入到同步代码块中。
 */
public class Demo02TicketTest {
    public static void main(String[] args) {
        //创建一个Ticket2对象
        Ticket2 t = new Ticket2();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
