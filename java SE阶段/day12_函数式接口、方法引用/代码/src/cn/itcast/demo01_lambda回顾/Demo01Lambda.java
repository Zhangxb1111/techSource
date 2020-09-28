package cn.itcast.demo01_lambda回顾;
/*
    Lambda表达式
    () -> {}

    Lambda表达式可以代替掉匿名内部类。

    Lambda标准格式
    (数据类型 变量名, 数据类型 变量名) -> {
        方法体;
        return 返回值;
    }

    Lambda表达式省略规则
        1. 参数位置的数据类型可以省略。
        2. 如果参数只有一个，那么可以省略小括号
        3. 如果大括号内只有一条语句，那么可以省略大括号，return，以及分号

    Lambda表示使用前提：
        1. 接口中有且仅有一个需要被重写的抽象方法。
        2. 必须支持上下文推倒。 要么把接口作为参数，要么用接口接收lambda表达式的结果。

    可推导就是可省略
 */

public class Demo01Lambda {
    public static void main(String[] args) {
        //使用匿名内部类创建多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行了");
            }
        }).start();

        //使用Lambda标准格式完成多线程
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "执行了");
        }).start();

        //使用Lambda简写格式完成多线程
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "执行了")).start();
    }
}
