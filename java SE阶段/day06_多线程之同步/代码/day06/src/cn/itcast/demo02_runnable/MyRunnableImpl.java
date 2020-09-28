package cn.itcast.demo02_runnable;

/*
    这个类不是线程类，因为这个类和Thread没有任何关系。

    我们可以把这个类称为线程任务类，里面仅仅定义了线程要执行的任务，也就是run方法。
 */
public class MyRunnableImpl implements Runnable{
    //在run方法中定义新线程要执行的任务
    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "在打印Hello World：" + i);
        }
    }
}
