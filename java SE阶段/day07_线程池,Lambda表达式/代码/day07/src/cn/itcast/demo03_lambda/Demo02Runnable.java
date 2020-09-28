package cn.itcast.demo03_lambda;
/*
    匿名内部类可以省略单独创建一个.java文件的步骤。
    但是匿名内部类也有他的弊端，弊端就是它语法太麻烦了.

    匿名内部类中最关键的东西是方法（参数，方法体，返回值）

    每个方法都有前中后三个东西。
    1. 前： 参数
    2. 中： 方法体
    3. 后： 返回值

    Runnable接口中重写的run方法，这三个东西分别是。
    没有参数： 调用run方法不需要给这个方法任何的信息。
    方法体： 打印语句，是这个线程要做的事情。
    返回值： 这个方法没有返回值，方法调用完成后并不会产生任何的结果。

    同样的效果，使用Lambda表达式，就就要简便很多。
    () -> {}  lambda表达式只需要关注参数，方法体，以及返回值。

    Lambda表达式由三个东西组成
        1. 一些参数。
        2. 一个箭头
        3. 一些语句

    Lambda表达式的标准格式：
        (参数类型 参数名) -> {
            方法体;
            return 返回值;
        }

   注意：
       1. 小括号中的参数可以写一个，可以没有，也可以有多个，如果有多个使用逗号隔开就可以。
       2. 箭头是一个运算符， 表示指向性动作。
       3. 大括号中的方法体和我们之前学习的传统的方法体基本是一致的

   Lambda表达式省略了面向对象中的条条框框。
   可推导就是可省略。
   因为Thread中有一个构造方法，这个构造方法需要Runnable接口类型的参数，所以可以推倒出来这个类型，所以可以省略new Runnable
   因为Runnable中只有一个抽象方法，所以重写的肯定是这个 方法，所以这个方法的方法声明是可以省略的。
 */
public class Demo02Runnable {
    public static void main(String[] args) {
        //单独创建一个Runnable实现类，然后创建这个类的对象，并实现多线程.
        MyRunnable r = new MyRunnable();
        new Thread(r).start();

        //使用匿名内部类完成多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了...");
            }
        }).start();

        //使用Lambda表达式完成多线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "执行了...");
        }).start();
    }
}
