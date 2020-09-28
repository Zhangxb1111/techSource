package cn.itcast.demo04_stream常见方法;

import java.util.Arrays;
import java.util.stream.Stream;

/*
    在Stream中有一个方法，可以获取到流中的前几个元素，这个方法叫做limit

    Stream<T> limit​(long maxSize)：参数表示获取前maxSize个元素。会把存放新的元素的流返回
 */
public class Demo03Limit {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd", "ee");

        //调用limit方法，获取前3个元素
        //会把前3个元素，放入到一个新的流对象中并返回。
        Stream<String> newStream = stream.limit(3);

        //打印新的流

        System.out.println(Arrays.toString(newStream.toArray()));
    }
}
