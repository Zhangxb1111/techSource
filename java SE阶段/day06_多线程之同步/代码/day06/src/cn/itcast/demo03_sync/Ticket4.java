package cn.itcast.demo03_sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("all") //注解，用来抑制警告
public class Ticket4 implements Runnable{

    int num = 100;

    //定义Lock锁对象，用于手动的获取锁以及手动的释放锁
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {
            //手动获取锁对象
            lock.lock();
            if(num > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "正在卖第" + num + "张票");
                num--;
            }
            //手动释放锁
            lock.unlock();
        }
    }
}
