package cn.itcast.demo01_exception;
/*
    运行时异常和编译时异常的区别。

    运行时异常： 指的是RuntimeException以及RuntimeException下面的所有子类。
    编译时异常： 指的是Exception以及Exception下面除了RuntimeException之外的其他子类。

    区别：
        编译时异常： 当一个方法内抛出编译时异常，必须要进行处理。要么使用throws声明这个方法会抛出异常。 要么使用trycatch直接把这个异常解决掉。
        运行时异常： 一个方法抛出运行时异常，可以处理，也可以不处理。


    如果希望让调用者知道自己这个方法可能会出现问题，那么最好用编译时异常。
    如果不想让调用者知道我这个方法会有问题，那么可以使用运行时异常。
 */
public class Demo08RuntimeException {
    public static void main(String[] args) {

    }

    //运行时异常： 一个方法抛出运行时异常，可以处理，也可以不处理。
    //如果运行时异常没有处理，等到程序运行的时候也会把这个异常抛给调用者。
    public static void method2() {
        throw new RuntimeException();
    }

    public static void method1() {
        try {
            //抛出一个编译时异常
            throw new Exception();
        } catch (Exception e) {

        }
    }
}
