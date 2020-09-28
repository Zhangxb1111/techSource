package cn.itcast.demo07_注解练习;

public class MyTestDemo {

    @MyTest
    public void method1() {
        System.out.println("method1");
    }

    public void method2() {
        System.out.println("method2");
    }
    @MyTest
    public void method3() {
        System.out.println("method3");
    }
}
