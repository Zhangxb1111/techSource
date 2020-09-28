package cn.itcast.demo03_thread;

public class MyThread extends Thread{

    //新线程执行的时候会调用run方法
    //所以要在run方法中定义线程要执行的任务。
    @Override
    public void run() {
        //在控制台打印100行hellojava
        for(int i = 1; i <= 1000; i++) {
            System.out.println("hello...java:" + i);
        }
    }
}
