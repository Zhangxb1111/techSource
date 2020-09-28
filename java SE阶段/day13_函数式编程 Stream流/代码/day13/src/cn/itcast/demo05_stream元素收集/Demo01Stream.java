package cn.itcast.demo05_stream元素收集;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    把Stream中的元素收集到一个集合中（就是把Stream中的元素放入到一个集合）

    如果要收集，可以使用stream对象的方法，这个方法叫做collect
    <R,A> R collect​(Collector collector)：可以将流中的数据放入到一个集合中
                                            参数是Collector类型表示要放入到哪种集合中

    参数Collector可以通过工具类Collectors获取。
    static <T> Collector toList​() ：如果调用的是这个方法，表示将数据收集到List集合中。
    static <T> Collector toSet​() ：如果调用的是这个方法，表示将数据收集到set集合中

 */
public class Demo01Stream {
    public static void main(String[] args) {
        //创建一个Stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "张无忌", "张天爱", "张二狗");

        //把stream中的元素放入到一个List集合中
        //List<String> list = stream.collect(Collectors.toList());
        //System.out.println("list:" + list);

        //把Stream中的元素放入到一个Set集合中
        Set<String> set = stream.collect(Collectors.toSet());
        System.out.println("set:" + set);
    }
}
