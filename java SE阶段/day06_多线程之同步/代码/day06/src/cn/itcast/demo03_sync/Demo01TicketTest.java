package cn.itcast.demo03_sync;
/*
    电影院要卖票，我们模拟电影院的卖票过程。假设要播放的电影是 “葫芦娃大战奥特曼”，本次电影的座位共100个
    (本场电影只能卖100张票)。
    我们来模拟电影院的售票窗口，实现多个窗口同时卖 “葫芦娃大战奥特曼”这场电影票(多个窗口一起卖这100张票)
    需要窗口，采用线程对象来模拟；需要票，Runnable接口子类来模拟

    使用三个线程去卖票
 */
public class Demo01TicketTest {
    public static void main(String[] args) {
        //创建Runnable接口实现类对象
        Ticket t = new Ticket();
        //创建三个线程，执行卖票的任务，并启动
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}
