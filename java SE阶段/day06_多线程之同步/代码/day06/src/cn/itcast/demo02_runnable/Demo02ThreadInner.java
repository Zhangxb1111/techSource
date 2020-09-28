package cn.itcast.demo02_runnable;

/*
    使用匿名内部类的方式创建多线程。

    匿名内部类格式：
        new 父类或者接口() {
            重写父类或接口的方法;
        }

    匿名内部类真正创建的是子类对象。
 */
public class Demo02ThreadInner {
    public static void main(String[] args) {
        //1. 使用继承Thread类的方式创建新的线程并运行。
        new Thread() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了");
            }
        }.start();

        //2. 使用实现Runnable接口的方式创建新的线程并运行
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了");
            }
        };

        new Thread(r).start();


        //使用匿名内部类加匿名对象。必须写熟.
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了");
            }
        }).start();

    }
}
