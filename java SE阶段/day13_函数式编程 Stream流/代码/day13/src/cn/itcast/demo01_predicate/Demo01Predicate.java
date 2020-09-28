package cn.itcast.demo01_predicate;

import java.util.function.Predicate;

/*
    如果要对某个数据进行判断，那么可以使用函数式接口Predicate，里面有一个抽象方法，就是用来进行判断的，这个方法叫做test

    抽象方法：
        boolean test​(T t)：用来验证一个数据是否合法。　如果合法，返回true

    默认方法：
        default Predicate<T> and​(Predicate other)： 对Predicate进行合并，合并之后的关系是并且的关系，相当于java中的&&
        default Predicate<T> or​(Predicate other)： 对Predicate进行合并，合并之后的关系是或者的关系，相当于java中的||
        default Predicate<T> negate​()： 取非。 相当于java中的!
 */
public class Demo01Predicate {
    public static void main(String[] args) {
        /*
        method(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() == 5;
            }
        });
        */

        //使用Lambda表达式
        method(s -> s.length() == 5);
    }

    public static void method(Predicate<String> p) {
        //使用test方法，验证hello它的长度是否为5
        boolean flag = p.test("hello");
        System.out.println("是否符合要求：" + flag);
    }
}
