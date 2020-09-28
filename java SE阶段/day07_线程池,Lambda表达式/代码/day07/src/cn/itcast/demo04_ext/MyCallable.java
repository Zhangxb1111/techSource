package cn.itcast.demo04_ext;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String>{

    //这个call方法，就是线程要执行的任务方法
    @Override
    public String call() throws Exception {
        System.out.println("线程执行了");
        return "hello";
    }
}
