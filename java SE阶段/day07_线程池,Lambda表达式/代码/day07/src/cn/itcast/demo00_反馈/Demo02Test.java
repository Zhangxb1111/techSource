package cn.itcast.demo00_反馈;
/*
    当使用多态调用方法时，在编译时期会检测左边父类类型中有没有这个方法，如果没有就宝座。

    当使用多态调用方法时， 在运行时期会执行右边子类对象的这个方法。
 */
public class Demo02Test {
    public static void main(String[] args) {
        //创建Dog对象。使用多态去表示
        Animal a = new Dog();

        a.sayHi();
    }
}
