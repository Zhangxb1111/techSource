package cn.itcast.demo06_对象引用成员方法;
/*
    方法引用的 4 + 2 种方式

    对于类来说，有4种方式
    1. 对象引用成员方法
    2. 类名引用静态方法
    3. super引用父类方法
    4. this引用本类方法

    对于构造器来说，有2种方法。
    1. 类的构造器引用
    2. 数组的构造器引用。


    对象引用成员方法
        对象名::方法名
 */
public class Demo01MethodRef {

    public static void main(String[] args) {
        method(s -> System.out.println(s.toUpperCase()));

        //创建MyClass对象
        MyClass myClass = new MyClass();
        method(s -> myClass.printStr(s));

        //使用方法引用。
        method(myClass::printStr);
    }

    public static void method(Printable p) {
        p.print("hello");
    }
}
