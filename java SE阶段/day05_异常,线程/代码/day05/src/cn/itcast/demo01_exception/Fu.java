package cn.itcast.demo01_exception;

import java.io.IOException;
/*
    如果父类方法会抛出异常， 那么子类可以不抛， 也可以抛。
    如果抛，要么和父类方法的异常相同，要么是父类方法异常的子类异常。

    如果父类方法没有抛出异常，那么子类重写的这个方法也不能抛。如果里面出现了异常，只能try...catch处理掉。
 */
public class Fu {
    public void method() throws IOException{

    }


    public void function() {

    }
}
