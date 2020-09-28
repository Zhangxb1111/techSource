package cn.itcast.demo01_thread;

public class MyThread extends Thread{

    //线程要执行的任务
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {
            System.out.println("Hello world:" + i);
        }
    }
}
