package cn.itcast.demo05_方法引用;

public class Demo02Lambda {
    public static void method(MyPrintNumberable myPrintNumberable) {
        myPrintNumberable.printNumber(100);
    }

    public static void main(String[] args) {
        //调用method方法，传递Lambda表达式
        method(num -> System.out.println(num));

        //使用方法引用进行改进
        method(System.out::println);
    }
}
