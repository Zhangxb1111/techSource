package cn.itcast.demo04_ext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
    Callable使用的时候，要通过线程池去执行任务。

    1. 获取一个线程池。
        Executors.newFixedThreadPool​

    2. 调用线程池的submit方法，提交任务，并得到结果。
        <T> Future<T> submit​(Callable<T> task)：返回值封装了这个线程调用call方法得到的结果

    3. 解析...

 */
public class Demo01MyCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //获取一个线程池。
        ExecutorService pool = Executors.newFixedThreadPool(2);

        //调用submit方法，执行这个线程
        Future<String> result = pool.submit(new MyCallable());

        //3. 解析...
        //调用get方法，获取结果
        System.out.println(result.get());
    }
}
