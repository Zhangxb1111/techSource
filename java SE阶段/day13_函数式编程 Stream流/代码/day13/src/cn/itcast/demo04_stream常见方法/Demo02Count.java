package cn.itcast.demo04_stream常见方法;

import java.util.stream.Stream;

/*
    在Stream中，有一个方法，可以获取流对象中元素的个数，这个方法叫做count

        long count​()： 返回此流中的元素数。
 */
public class Demo02Count {
    public static void main(String[] args) {
        //获取一个流对象
        Stream<String> stream = Stream.of("aa", "bbbb", "cccc", "dd");
        //获取流对象中元素的个数
        //long count = stream.count();
        long count = stream.filter(s -> s.length() > 2).count();

        System.out.println(count);
    }
}
