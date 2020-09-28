package cn.itcast.demo03_stream;

import java.util.Arrays;
import java.util.stream.Stream;

/*
    在java中，也可以使用数组去获取一个流对象。

    方式：
        1. 通过Stream的静态方法of，传递一个数组，就可以得到这个数组对应的流对象（推荐）
            static <T> Stream<T> of​(T... values)： 参数是可变参数，因为可变参数本质就是数组，所以也可以传递数组

        2. 通过Arrays工具类
            static <T> Stream<T> stream​(T[] array)： 根据参数数组获取到对应的Stream流。


 */
public class Demo05GetStream {
    public static void main(String[] args) {
        String[] strArr = {"貂蝉", "西施", "王昭君", "杨玉环"};

        //1. 通过Stream的静态方法of
        //根据上面的数组获取到对应的流对象
        Stream<String> stream = Stream.of(strArr);
        System.out.println(Arrays.toString(stream.toArray()));

        //2. 通过Arrays工具类获取
        Stream<String> stream2 = Arrays.stream(strArr);
        System.out.println(Arrays.toString(stream2.toArray()));
    }
}
