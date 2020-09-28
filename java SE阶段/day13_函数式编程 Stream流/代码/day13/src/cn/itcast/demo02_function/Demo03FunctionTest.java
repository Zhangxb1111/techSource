package cn.itcast.demo02_function;

import java.util.function.Function;

/*
    请使用 Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为
        1. 将字符串截取数字年龄部分，得到字符串；
        2. 将上一步的字符串转换成为int类型的数字；
        3. 将上一步的int数字累加100，得到结果int数字

    需要两个Function 对象
        第一个Function对象： 将字符串类型的年龄转成int数字
        第二个Function对象： 将int数字加上100

 */
public class Demo03FunctionTest {
    public static void main(String[] args) {
        //定义字符串
        String str = "赵丽颖,20";

        method(s -> Integer.parseInt(s.split(",")[1]),
                age -> age + 100,
                str);
    }
    /*
        第一个Function对象： 将字符串类型的年龄转成int数字
        第二个Function对象： 将int数字加上100
     */
    public static void method(Function<String, Integer> one, Function<Integer, Integer> two, String str) {
        //one.apply做的事情，是获取到字符串中的年龄，并且把这个年龄转成数字
        //Integer age = one.apply(str);
        //two.apply做的事情，是将上一步得到的年龄加上100返回
        //Integer result = two.apply(age);

        //进行合并
        Integer result = one.andThen(two).apply(str);

        System.out.println("result:" + result);
    }
}
