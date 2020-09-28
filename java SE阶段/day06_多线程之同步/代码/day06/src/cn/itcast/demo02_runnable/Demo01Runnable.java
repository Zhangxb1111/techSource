package cn.itcast.demo02_runnable;
/*
    多线程的第二种实现方式： 实现Runnable接口的方式。

    步骤：
        1. 定义一个类，实现Runnable接口
        2. 重写里面的run方法，定义线程要执行的任务。
        3. 在测试类中创建Runnable接口实现类对象
        4. 再创建Thread对象，并且把Runnable接口实现类对象传递过去。
        5. 调用start方法，开启这个线程。

    多线程两种实现方式：
        方式一： 继承Thread类的方式
        方式二： 实现Runnable接口的方式。

    第二种方式的好处：
        1. 解决了java中类与类之间只能单继承的局限性。
        2. Runnable接口中只有一个run方法，没有start，setName，sleep，getName等等等， Runnable接口
           中的方法更加的纯粹，我们只需要在里面关注线程要执行的任务就可以了。更加符合设计模式中的单一职责原则。
        3. 解耦
        4. 可以更加方便的实现线程之间的数据共享。
 */
public class Demo01Runnable {
    public static void main(String[] args) {
        //创建Runnable接口实现类对象
        MyRunnableImpl mr = new MyRunnableImpl();
        //再创建Thread对象，并且把Runnable接口实现类对象传递过去。
        Thread t = new Thread(mr);
        //调用start方法，开启这个线程。
        t.start();


        for(int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "线程在打印Hello Java：" + i);
        }

    }
}
