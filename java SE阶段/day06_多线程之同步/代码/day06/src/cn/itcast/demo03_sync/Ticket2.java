package cn.itcast.demo03_sync;

@SuppressWarnings("all") //注解，用来抑制警告
public class Ticket2 implements Runnable{

    int num = 100;

    //定义一个对象，用来当做锁对象
    //这个对象并没有特别的作用，只是当做一个标记。
    //锁对象可以是任意对象，可以是Object，Student，Person
    //一定要保证多个线程用的是同一个锁对象。
    Object lock = new Object();

    @Override
    public void run() {
        while(true) {
            //当一个线程执行到synchronize代码块上
            //这个线程会先看一下上面还有锁吗
            //如果同步代码块上面还有锁对象，那么这个线程就会把这个锁对象拿走，并且自己会进入到同步代码块里面。
            //如果同步代码块上面没有锁对象，那么这个线程会一直在这里等着。什么时候锁对象来了，我再去获取这个锁对象。
            synchronized (lock) {
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
            //当一个线程离开同步代码块，会释放自己的锁。
        }
    }
}
