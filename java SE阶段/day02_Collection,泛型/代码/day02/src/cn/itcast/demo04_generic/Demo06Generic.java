package cn.itcast.demo04_generic;

public class Demo06Generic {
    public static void main(String[] args) {
        //创建实现类对象
        MyImplA ma = new MyImplA();
        Phone p = ma.method(new Phone());

        //使用第二种方式创建实现类对象的时候确定泛型
        MyImplB<Phone> mb = new MyImplB<>();
        Phone p2 = mb.method(new Phone());
    }
}
