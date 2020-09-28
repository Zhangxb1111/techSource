package cn.itcast.demo05_ext;

public class Demo01DeadLockTest {
    public static void main(String[] args) {
        //创建一个DeadLock对象
        DeadLock deadLock = new DeadLock();

        new Thread(deadLock).start();
        new Thread(deadLock).start();
    }
}
