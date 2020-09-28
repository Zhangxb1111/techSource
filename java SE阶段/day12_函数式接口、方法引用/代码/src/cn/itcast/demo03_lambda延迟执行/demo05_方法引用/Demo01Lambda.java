package cn.itcast.demo03_lambda延迟执行.demo05_方法引用;
/*
    Lambda表达式做的事情是，拿到参数之后【直接】对参数进行了打印。

    如果Lambda表达式做的事情，和某个方法是一样的。
    如果再重复写一遍方法的参数就有些多余了，因为在里面做的事情是拿到参数之后直接对参数进行打印。
    如果Lambda表达式做的事情和方法一样，可以使用Lambda表达式的一个孪生兄弟去表示，叫做方法引用。


    方法引用符号
        ::  两个连续的冒号

 */
public class Demo01Lambda {
    public static void method(Printable printable) {
        printable.print("hello");
    }

    public static void main(String[] args) {
        method(s -> System.out.println(s));

        //直接把参数s 进行了打印
        method(System.out::println);
    }
}
