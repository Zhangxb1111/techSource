package cn.itcast.demo03_sync;

@SuppressWarnings("all") //注解，用来抑制警告
public class Ticket3 implements Runnable{

    int num = 100;

    Object lock = new Object();

    @Override
    public void run() {
        while(true) {
            sell();
        }
    }

    //同步方法，就是把整个方法体都加了同步代码块。

    public synchronized void sell() {
        if(num > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "正在卖第" + num + "张票");
            num--;
        }
    }
/*
    public void sell() {
        synchronized (this) {
            if(num > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "正在卖第" + num + "张票");
                num--;
            }
        }
    }
    */
}
