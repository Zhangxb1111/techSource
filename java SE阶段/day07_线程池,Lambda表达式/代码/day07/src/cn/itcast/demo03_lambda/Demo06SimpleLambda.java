package cn.itcast.demo03_lambda;
/*
    Lambda省略格式。

    可推到就是可省略

    Lambda表达式的标准格式：
        (参数类型 参数名) -> {
            方法体;
            return 返回值;
        }

    1. 小括号中的参数类型可以省略。
    2. 如果参数只有一个，那么可以省略小括号。
    3. 如果大括号中只有一条语句，那么不管这个方法有没有返回值，都可以省略大括号，return，以及分号.
 */
public class Demo06SimpleLambda {
    public static void invokeMethod(MyInterface myInterface) {
        myInterface.method(10);
    }

    public static void main(String[] args) {
        //使用Lambda标准格式，调用invokeMethod传递Lambda
        invokeMethod((int a) -> {
            System.out.println(a);
        });

        //省略参数的参数类型
        invokeMethod((a) -> {
            System.out.println(a);
        });

        //如果参数只有一个，那么可以省略小括号。
        invokeMethod(a -> {
            System.out.println(a);
        });

        //如果大括号中只有一条语句，那么不管这个方法有没有返回值，都可以省略大括号，return，以及分号.
        invokeMethod(a -> System.out.println(a));

    }
}
