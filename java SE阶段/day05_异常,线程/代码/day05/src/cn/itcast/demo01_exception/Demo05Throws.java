package cn.itcast.demo01_exception;

import java.io.IOException;

/*
    throw：  手动的创建一个异常对象并抛出。是抛出
    throws： 用来声明这个方法可能会抛出一个异常。 是声明。

    throws使用格式

    修饰符 返回值类型 方法名(参数列表) throws 异常类名{
        方法体;
        return 返回值;
    }

    注意：
        1. 如果一个方法内抛出了编译时异常，那么一定要在这个方法上面加上throws异常声明。（也可以try...catch）
        2. 如果方法内抛出的是运行时异常， 那么可以是使用throws声明，也可以不使用。
        3. 如果一个方法内抛出了多个异常，可以使用throws关键字声明这个方法会抛出多个异常。
        4. 如果一个方法可能抛出多个异常，那么除了第3种做法之外，也可以使用throws声明他们的父类异常。
 */
public class Demo05Throws {
    public static void main(String[] args) {

    }

    // 4. 如果一个方法可能抛出多个异常，那么除了第3种做法之外，也可以使用throws声明他们的父类异常。
    public static void method4() throws Exception{
        int i = 1;
        if(i % 2 == 0) {
            throw new IOException();
        } else {
            throw new ClassNotFoundException();
        }
    }

    //如果一个方法内抛出了多个异常，可以使用throws关键字声明这个方法会抛出多个异常。
    public static void method3() throws IOException, ClassNotFoundException{
        int i = 1;
        if(i % 2 == 0) {
            throw new IOException();
        } else {
            throw new ClassNotFoundException();
        }
    }

    //如果方法内抛出的是运行时异常， 那么可以是使用throws声明，也可以不使用。
    public static void method2() {
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void method1() throws IOException{
        //手动抛出一个编译时异常.
        //编译时异常是 Exception和Exception下面除了RuntimeException之外的其他子类
        throw new IOException();
    }
}
