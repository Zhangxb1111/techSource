package cn.itcast.demo03_lambda;
/*
    匿名内部类语法比较冗余的。

    因为创建的是Runnable接口的实现类对象，所以不得不new Runnable
    因为要重写run方法，所以不得不再写一遍方法的声明.

    里面最关键的部分是方法的内容。

    每个方法都可以有前中后三个关键的东西组成
    1. 前： 参数。
    2. 中： 方法体
    3. 后： 返回值

    我们只关注这三个关键的部分就可以了.
 */
public class Demo01RunnableInner {
    public static void main(String[] args) {
        //使用匿名内部类实现多线程
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了");
            }
        }).start();

        //Lambda表达式初体验
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "执行了");
        }).start();

    }
}
