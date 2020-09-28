package cn.itcast.test;
/*
    ThreadLocal 叫做线程局部变量，可以在当前线程上绑定数据，这个数据可以在当前线程的任何位置共享

    ThreadLocal<T>可以看成一个 Map集合，key是线程对象， value是在这个线程上绑定的数据

    ThreadLocal中有三个常见的方法
    void set​(T value)： 在当前线程上设置数据
    T get​()： 获取当前线程上绑定的数据。
    void remove​()： 移除当前线程上绑定的数据。

    在哪个线程中调用的set方法，就是将数据绑定到了哪个线程上，
    在哪个线程上调用get方法，就是获取的哪个线程上的数据。

    一个ThreadLocal只能在一个线程上绑定一个数据，如果要绑定多个，需要创建多个ThreadLocal对象。

    扩展 ThreadLocal里面的数据使用完之后要调用remove，不然会引发内存泄漏。
 */
public class Demo01ThreadLocal {
    public static void main(String[] args) {
        //创建的ThreadLocal，用于在当前线程上绑定数据
        ThreadLocal<String> local = new ThreadLocal<>();

        //调用set方法，在当前线程上绑定一个字符串
        local.set("你好"); //将你好绑定到了main线程上

        //新建一个线程
        new Thread(() -> {
            local.set("我好哈哈哈");
            System.out.println("新线程中的数据：" + local.get());
        }).start();

        //移除
        //local.remove();

        System.out.println("main线程上的数据：" + local.get());//get方法获取当前线程上绑定的数据
    }
}
