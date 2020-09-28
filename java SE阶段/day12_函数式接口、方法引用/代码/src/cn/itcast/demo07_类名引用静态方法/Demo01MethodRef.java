package cn.itcast.demo07_类名引用静态方法;
/*
    类名引用静态方法

        类名::静态方法
 */
public class Demo01MethodRef {
    public static void main(String[] args) {
        //method(num -> num > 0 ? num : -num);

        //在java中，有一个数学工具类，这个类叫做Math，里面有一个静态方法，叫做abs可以直接求出绝对值。
        //method(num -> Math.abs(num));

        method(-10, Math::abs);
    }

    public static void method(int num, Calcutator c) {
        int result = c.abs(num);
        System.out.println(result);
    }
}
