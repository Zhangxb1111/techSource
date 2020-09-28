package cn.itcast.demo03_lambda;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行了...");
    }
}
