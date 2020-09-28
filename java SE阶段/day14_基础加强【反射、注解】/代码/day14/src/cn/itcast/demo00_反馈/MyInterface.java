package cn.itcast.demo00_反馈;
/*
    如果一个接口中有且仅有一个需要被重写的抽象方法，那么这个接口就是函数式接口
 */

@FunctionalInterface
public interface MyInterface {
    void method();
}
