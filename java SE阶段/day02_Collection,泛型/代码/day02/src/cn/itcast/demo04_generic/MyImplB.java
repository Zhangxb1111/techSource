package cn.itcast.demo04_generic;

/*
    相当于把泛型从接口中拿下来了，并没有确定这个泛型到底是什么类型
 */
public class MyImplB<T> implements MyInterface<T>{
    @Override
    public T method(T t) {
        return null;
    }
}
