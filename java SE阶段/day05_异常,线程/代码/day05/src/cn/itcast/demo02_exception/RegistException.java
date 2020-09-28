package cn.itcast.demo02_exception;
/*
    如何自定义一个异常？
        认贼作父。 找一个异常类当做父类。

    如果使用一个类继承了异常类，那么这个类也就变成了异常类。

    如果这个类继承的是编译时异常，那么这个类就会变成编译时异常类。
    如果这个类继承的是运行时异常，那么这个类就会变成运行时异常类。

 */

//定义注册异常
public class RegistException extends RuntimeException{
    public RegistException() {
    }

    public RegistException(String message) {
        super(message);
    }
}
