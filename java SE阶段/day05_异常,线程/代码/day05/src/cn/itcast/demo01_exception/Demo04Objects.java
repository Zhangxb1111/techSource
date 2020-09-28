package cn.itcast.demo01_exception;

import java.util.Objects;

/*
    Objects里面有一个方法，可以判断一个对象是否是null，如果是null会直接抛出一个空指针异常。

        static <T> T requireNonNull​(T obj)：判断指定的对象是否是null。
        static <T> T requireNonNull​(T obj, String message)： 第二个参数message表示异常信息。
 */
public class Demo04Objects {
    public static void main(String[] args) {
        Object obj = null;

        //判断obj是否是null，如果是null我就手动抛出一个异常对象
        /*
        if(obj == null) {
            //手动抛出一个空指针异常.
            throw new NullPointerException("某个对象的值是null");
        }
        */

        Objects.requireNonNull(obj, "出现了空指针异常");

        obj.toString();
    }
}
