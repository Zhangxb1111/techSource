package cn.itcast.demo09_this引用本类的方法;
/*
    this引用本类的方法格式：
        this::方法名
 */
public class Demo01MethodRef {
    public static void main(String[] args) {
        //创建一个Man对象
        Man man = new Man();
        man.beHappy();
    }
}
