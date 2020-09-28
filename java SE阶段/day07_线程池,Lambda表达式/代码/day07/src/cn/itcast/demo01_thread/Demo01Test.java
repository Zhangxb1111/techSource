package cn.itcast.demo01_thread;
/*
    线程等待唤醒机制。

    用到的API， 下面的方法都是Object中的。
        void wait​()： 让当前的线程等待。
        void notify​()： 随机唤醒一个线程
        void notifyAll​()： 唤醒所有的线程。

    上面这些方法虽然是Object中的方法，但是不能通过对象直接去调用
    这些方法一定要放在同步代码块中，并且使用锁对象（对象监视器）去调用。

    当一个线程调用wait方法后，会释放自己的锁。

    wait和sleep的方法的区别了：
        wait方法会释放锁
        sleep方法不会释放锁。
 */
public class Demo01Test {
    public static void main(String[] args) {
        //创建一个包子对象
        BaoZi baoZi = new BaoZi();
        //创建一个包子铺对象
        BaoZiPu baoZiPu = new BaoZiPu(baoZi);
        //创建一个吃货对象
        ChiHuo chiHuo = new ChiHuo(baoZi);

        //分别创建两个线程，去执行这两个任务
        new Thread(baoZiPu).start();
        new Thread(chiHuo).start();
    }
}
