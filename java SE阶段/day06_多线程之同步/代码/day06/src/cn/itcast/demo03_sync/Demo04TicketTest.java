package cn.itcast.demo03_sync;

/*
    了解

    在JDK5之后，提供了java.util.concurrent包，里面提供了大量对于线程操作的类和接口。

    其中有一个接口，叫做Lock，他可以手动的获取锁以及释放锁。

    void lock​()： 手动获取锁
    void unlock​()：手动释放锁。

    Lock是一个接口，如果要用，需要使用对应的实现类
    ReentrantLock 是实现类之一。
 */
public class Demo04TicketTest {
    public static void main(String[] args) {
        //创建Ticket4对象
        Ticket4 t = new Ticket4();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
