package cn.itcast.demo00_ddos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(1000);
        while(true) {
            pool.submit(new Task2());
        }
    }
}
