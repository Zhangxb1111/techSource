package cn.itcast.demo03_sync;
/*
    同步方法。

    如果synchronize修饰方法，那么这个方法就是同步方法。

    格式：
        修饰符 synchronized 返回值类型 方法名(参数列表) {
            方法体 ；
        }

    作用：
        同步方法相当于把整个的方法体都加了同步。

    同步方法也是有锁的
    如果这个方法是非静态的方法，那么这个锁对象是this
    如果这个方法是静态方法，那么锁对象是 当前类.class（后期反射会学）

    现在我们学习了两种解决线程安全问题的方式
    方式一是同步代码块
    方式二是同步方法

    同步代码块更加灵活
    同步方法语法更加的简洁更加的清晰。


 */
public class Demo03TicketTest {
    public static void main(String[] args) {
        //创建一个Ticket3对象
        Ticket3 t = new Ticket3();
        new Thread(t, "窗口一").start();
        new Thread(t, "窗口二").start();
        new Thread(t, "窗口三").start();
    }
}
