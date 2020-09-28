package cn.itcast.demo03_sync;
/*
    定义票
    并且这个类是线程任务类，线程要执行的任务是卖票
    所以还要再run方法中进行卖票的操作。


    如果多个线程操作共享数据，那么有可能引发线程安全问题。
 */
public class Ticket implements Runnable{

    //定义票
    int num = 100;

    //在run方法中进行买票的操作
    @Override
    public void run() {
        //定义死循环一直去卖票
        while(true) {
            //如果还有票，那么就卖票
            if(num > 0) {
                //掏身份证，磨磨唧唧，用了10ms
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //进行卖票操作
                System.out.println(Thread.currentThread().getName() + "正在卖第" + num + "张票");
                num--;
            }
        }
    }
}
