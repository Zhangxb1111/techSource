package cn.itcast.demo02_函数式接口;
/*
    函数式接口

    如果一个接口内有且仅有一个需要被重写的方法，那么这个接口就是一个函数式接口

    函数式接口的作用：
        1. 可以当做普通接口去使用  implements
        2. 当做Lambda表达式的使用前提

    有一个注解，可以验证一个接口是否是函数式接口。这个注解叫做FunctionalInterface

    如果一个接口只有一个需要被重写的抽象方法，但是这个接口上面没有FunctionalInterface这个注解，这个
    还是函数式接口
 */
@FunctionalInterface
public interface MyInterface {
    void method();
}
