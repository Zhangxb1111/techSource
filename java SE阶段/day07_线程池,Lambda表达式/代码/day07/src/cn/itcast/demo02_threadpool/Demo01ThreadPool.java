package cn.itcast.demo02_threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    线程池就是一个容器，里面存放了很多个线程，可以直接去执行任务。

    线程池核心API

    Executor接口： 是线程池的顶层接口，里面只有一个功能，就是提交线程要执行的任务。
    ExecutorService接口： 是Executor的子接口。里面处了有提交线程任务的功能外，还有管理线程的功能。
    Executors线程池工具类： 里面有方法可以直接获取到一个线程池。
                           线程池对象不是new出来的，而是通过Executors调用方法获取到的。


    Executors中获取线程池的方法
        static ExecutorService newFixedThreadPool​(int nThreads)：
        参数是一个长度。创建一个定长的线程池，超出的任务会在队列中等待。

    线程池的使用步骤：
        1. 调用Executors的newFixedThreadPool方法获取一个线程池。
        2. 定义一个类，然后实现Runnable接口，重写run方法，定义线程要执行的任务。
        3. 调用submit方法，传递Runnable接口实现类对象，使用线程池中的线程执行该任务。
                submit​(Runnable task)：提交一个任务并且执行。
   　　４.　销毁线程池（一般不做）
                shutdown​()：销毁线程池

    扩展其他线程池，这些线程池也是通过线程池工具类Executors的方法获取。
        static ExecutorService newCachedThreadPool​()： 创建一个长度可变的线程池.
        static ExecutorService newFixedThreadPool​(int nThreads)：创建一个定长的线程池.
        static ScheduledExecutorService newScheduledThreadPool​(int corePoolSize)： 创建一个支持周期性执行任务的线程池。
        static ExecutorService newSingleThreadExecutor​()：创建一个单线程的线程池。
        这个线程池每次只能执行一个任务，但是可以执行每个线程他们的执行顺序。

 */
public class Demo01ThreadPool {
    public static void main(String[] args) {
        //调用Executors的newFixedThreadPool方法获取一个线程池。
        ExecutorService pool = Executors.newFixedThreadPool(2);

        //调用submit方法，传递Runnable接口实现类对象，使用线程池中的线程执行该任务。
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());

        //销毁线程池（一般不做）
        pool.shutdown();
    }
}
