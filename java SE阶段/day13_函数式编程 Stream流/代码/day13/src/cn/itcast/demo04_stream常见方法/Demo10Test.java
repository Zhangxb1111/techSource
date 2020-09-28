package cn.itcast.demo04_stream常见方法;

import java.util.stream.Stream;
/*
    注意：
    1. Stream流中的非终结方法， 返回值是Stream类型，并且这个返回的Stream对象并不是调用者本身
    2. Stream对象只能一次性使用，不能二次使用
 */
public class Demo10Test {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("aa", "bb", "cc", "dd");
        //Stream<String> stream2 = stream.limit(2);
        //System.out.println(stream2 == stream);

        //Stream对象只能一次性使用，不能二次使用
        stream.limit(2);
        stream.limit(2); //不能二次使用
    }
}
