package cn.itcast.demo05_stream元素收集;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
     练习：将数组元素加到集合中
 */
public class Demo03Stream {
    public static void main(String[] args) {
        //定义一个数组
        String[] strArr = {"张三丰", "张翠山", "张无忌", "张天爱", "张二狗"};
        //先通过数组得到对应流对象
        //将流对象中的元素收集到集合
        //遍历集合
        List<String> list = Stream.of(strArr).collect(Collectors.toList());

        for (String s : list) {
            System.out.println(s);
        }
    }
}
