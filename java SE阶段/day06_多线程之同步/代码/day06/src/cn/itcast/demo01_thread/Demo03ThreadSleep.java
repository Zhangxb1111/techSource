package cn.itcast.demo01_thread;
/*
    static void sleep​(long millis)：线程休眠，参数是休眠多少毫秒
 */
public class Demo03ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start...");

        Thread.sleep(5000);

        System.out.println("end...");
    }
}
