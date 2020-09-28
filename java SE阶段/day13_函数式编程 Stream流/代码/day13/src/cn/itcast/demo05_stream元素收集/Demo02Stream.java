package cn.itcast.demo05_stream元素收集;

import java.util.Arrays;
import java.util.stream.Stream;

/*
    把Stream中的数据收集到数组中。

    直接调用流对象的toArray方法就可以了

        Object[] toArray​()： 把流转成Object数组

        <A> A[] toArray​(IntFunction generator)： 可以转成一个指定类型的数组。
                                                  参数是一个函数式接口，函数式接口可以传递Lambda， Lambda也可以使用方法引用代替。
                                                  我们要在这个位置传递一个数组的构造器引用，传递的是哪种构造器，就创建出来的是什么类型的数组
 */
public class Demo02Stream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("张三丰", "张翠山", "张无忌", "张天爱", "张二狗");
        //把流中的元素放入到一个数组中
        //Object[] objs = stream.toArray();
        //System.out.println(Arrays.toString(objs));


        //<A> A[] toArray​(IntFunction generator)： 可以转成一个指定类型的数组。
        String[] strArr = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(strArr));
    }
}
