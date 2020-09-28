package cn.itcast.demo02_threadpool;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {

            System.out.println(Thread.currentThread().getName() + "：HelloWorld：" + i);
        }
    }
}
