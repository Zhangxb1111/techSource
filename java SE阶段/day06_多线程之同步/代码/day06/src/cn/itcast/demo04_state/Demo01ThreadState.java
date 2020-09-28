package cn.itcast.demo04_state;
/*
    了解
    NEW： 新建状态。假如一个线程刚刚new出来，但是没有调用start方法，那么这个线程就处于此状态。
    RUNNABLE：运行状态，线程调用start方法之后，就会变成运行状态。
    BLOCKED：受阻塞。　当一个线程等待同步锁的时候，那么这个线程就是受阻塞状态。
    WAITING：无限等待。　当一个线程调用wait方法后，就变成了无限等待。（明天案例中去说）
    TIMED_WAITING：计时等待。 当一个方法调用sleep(毫秒数) 这个线程所处的状态就是计时等待
    TERMINATED：退出。　当一个线程执行结束或者调用线程的stop方法，这个线程就会变成退出状态
 */
public class Demo01ThreadState {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start...");
        Thread.sleep(1000);
        System.out.println("end...");
    }
}
