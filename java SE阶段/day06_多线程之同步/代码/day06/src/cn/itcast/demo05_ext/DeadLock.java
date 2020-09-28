package cn.itcast.demo05_ext;

public class DeadLock implements Runnable{
    //定义两个锁
    Object lockA = new Object();
    Object lockB = new Object();
    int count = 0;//用于计数的变量

    @Override
    public void run() {
        while(true) {
            if (count % 2 == 0) {
                synchronized (lockA) {
                    System.out.println("if...lockA");
                    synchronized (lockB) {
                        System.out.println("if...lockB");
                    }
                }
            } else {
                synchronized (lockB) {
                    System.out.println("else...lockB");
                    synchronized (lockA) {
                        System.out.println("else...lockA");
                    }
                }
            }
            count++;
        }
    }
}
