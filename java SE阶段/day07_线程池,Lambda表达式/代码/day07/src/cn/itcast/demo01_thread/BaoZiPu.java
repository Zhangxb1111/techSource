package cn.itcast.demo01_thread;
/*
    包子铺
 */
public class BaoZiPu implements Runnable{
    private BaoZi baoZi;
    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    //包子铺线程执行的任务
    @Override
    public void run() {
        //包子铺要一直不停的生产包子，所以使用死循环
        while(true) {
            //因为包子铺和吃货线程用的包子是同一个，所以可以把baoZi当成是锁对象。
            synchronized (baoZi) {
                //如果还有包子，包子铺就等着吃货把这个包子吃完
                if(baoZi.flag) {
                    //调用wait方法，让包子铺这个线程等待
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //如果没有包子，那么就生产包子。
                System.out.println("包子铺生产了一个包子...吃货你快来吃...");
                baoZi.xianer = "五仁";
                baoZi.flag = true;//把标记改为true表示包子已经生成完成了.

                //包子铺生产完这个包子，要唤醒吃货去吃包子。
                baoZi.notify();

            }
        }
    }
}
