package cn.itcast.demo04_stream常见方法;

import java.util.Arrays;
import java.util.stream.Stream;

/*
     在Stream里面有一个静态方法，叫做Concat，可以将两个流合并成一个流

     static <T> Stream<T> concat​(Stream a, Stream b)： 将a和b这两个流合并成一个
 */
public class Demo06Concat {
    public static void main(String[] args) {
        //创建两个Stream流对象
        Stream<String> streamOne = Stream.of("aa", "bb");
        Stream<String> streamTwo = Stream.of("cc", "dd");

        //通过Stream中的concat方法，将上面两个流合并成一个
        Stream<String> totalStream = Stream.concat(streamOne, streamTwo);

        System.out.println(Arrays.toString(totalStream.toArray())); //[aa, bb, cc, dd]
    }
}
