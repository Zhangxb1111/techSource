package cn.itcast.demo01_exception;
/*
    如果遇到异常之后，不希望把异常往外抛， 希望自己解决这个异常，那么可以使用try...catch关键字。

    格式:
        try {
            1. 要检测的代码
        } catch(异常类名 变量名) {
            2. 异常的处理方式的代码。
        }

    执行流程：
        1. 会执行try中的代码，如果try中的代码没有出现异常，那么就会跳过catch往下执行。
        2. 如果try中的代码出现了异常，并且catch捕获到了这个异常，那么就执行执行catch中的语句。

    注意：
        1. 如果try中的代码出现了问题，那么如果catch捕获到了这个异常，会直接进入到catch中。
        2. 如果try中的代码出现了问题，但是catch并没有捕获到，那么这个异常会依旧抛给调用者。


    总结：
        异常有两种处理方式
        1. 往外抛（甩锅）
            throw, throws
        2. 自己真正的把这个异常给解决了
            try...catch
 */
public class Demo06TryCatch {
    public static void main(String[] args) {
        try {
            Object obj = null;
            obj.toString();
            System.out.println("1.try....");
        } catch (Exception e) {//如果catch捕获的是父类异常，那么可以捕获到对应的子类异常。
            System.out.println("2.catch...");
        }
        System.out.println("3.end...");
    }
}
