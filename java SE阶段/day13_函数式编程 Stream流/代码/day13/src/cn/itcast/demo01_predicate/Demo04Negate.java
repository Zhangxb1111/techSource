package cn.itcast.demo01_predicate;

import java.nio.file.attribute.AclEntryFlag;
import java.util.function.Predicate;

/*
    在Predicate中，有一个默认方法，可以对判断之后的结果进行取反，这个方法叫做negate。

    这个negate 不需要两个Predicate，只需要一个negate就可以了
 */
public class Demo04Negate {
    public static void main(String[] args) {
        method(s -> s.length() == 5);
    }
    /*
        参数传递一个Predicate类型，用来验证字符串的长度是否满足要求
     */
    public static void method(Predicate<String> p) {
        boolean flag = p.negate().test("hello");
        System.out.println("flag: " + flag);
    }
}
