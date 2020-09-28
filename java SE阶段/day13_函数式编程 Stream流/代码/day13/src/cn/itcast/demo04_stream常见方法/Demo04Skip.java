package cn.itcast.demo04_stream常见方法;

import java.util.Arrays;
import java.util.stream.Stream;

/*
    如果希望跳过流中的前几个元素可以使用skip方法

    Stream<T> skip​(long n)：参数表示跳过前n个元素。  并且这个方法会把剩下的元素放入到一个新的集合并且把这个新的Stream返回
 */
public class Demo04Skip {
    public static void main(String[] args) {
        //获取一个流对象
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd", "ee");

        //跳过stream流中的前2个元素，获取后面的元素
        Stream<String> newStream = stream.skip(2);

        System.out.println(Arrays.toString(newStream.toArray()));
    }
}
