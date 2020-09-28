package cn.itcast.demo01_exception;
/*
    try...catch...finally

    格式：
        try {
            【A. 要检测可能会出现异常的代码】
        } catch(异常类名 变量名) {
            【B. 出现异常之后该怎么做的代码】
        } finally {
            【C. 一定会执行的代码】
        }
    注意：
        不管程序结果如何，finally代码块一定会执行。

    执行流程：
        假如try中的代码没有出现异常： 【A】【C】
        假如try中的代码出现了异常并且catch捕获到了这个异常： 【A】【B】【C】
        假如try中的代码出现了异常但是catch没有捕获到： 【A】【C】【把异常抛给调用者】

    finally代码块不管怎样一定会执行。

    finally代码块的使用场景。
        一般用在释放资源。比如后期IO流释放资源，jdbc释放连接....

 */
public class Demo07TryCatchFinally {
    public static void main(String[] args) {
        try {
            System.out.println("1.try...start");
            Object obj = null;
            obj.toString();
            System.out.println("2.try...end");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("3.catch");
        } finally {
            System.out.println("4.finally");
        }
    }
}
