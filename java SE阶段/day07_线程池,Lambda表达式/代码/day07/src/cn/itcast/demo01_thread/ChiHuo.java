package cn.itcast.demo01_thread;
/*
    吃货
 */
public class ChiHuo implements Runnable{
    private BaoZi baoZi;
    public ChiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    //吃货线程要做的任务。
    //吃包子
    @Override
    public void run() {
        //因为吃货要一直不停的吃包子，所以可以使用死循环
        while(true) {
            synchronized (baoZi) {
                //如果没有包子，那么吃货就等着.
                if(!baoZi.flag) {
                    //如果还没有包子，那么就调用wait方法等着
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //如果有包子， 那么就吃.
                System.out.println("吃货把这个包子给吃掉了，吃的是" + baoZi.xianer + "的包子");
                baoZi.flag = false;
                //如果吃完，就调用notify方法唤醒包子铺线程去生产包子
                baoZi.notify();

            }
        }
    }
}
