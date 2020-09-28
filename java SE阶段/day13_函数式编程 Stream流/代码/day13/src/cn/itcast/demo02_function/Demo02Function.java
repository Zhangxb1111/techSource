package cn.itcast.demo02_function;

import java.util.function.Function;

/*
    在Function接口中，有一个默认方法，可以对两个Function进行合并。

    举例：
        "10" -> 10： 使用一个Function，接收一个字符串类型的参数，返回一个Integer类型的结果
         10  -> 110： 使用另一个Function，接收一个Integer类型的参数（这个参数是上一个Function计算的结果）， 返回一个Integer数字

        合并：
        "10" -> 10 -> 110  将字符串类型的"10" 转成数字10， 再把这个数字10加上100返回

 */
public class Demo02Function {
    public static void main(String[] args) {
        method(s -> Integer.parseInt(s),
                num -> num + 100);
    }
    /*
        参数两个Function
        第一个Function：将字符串类型的"10"转成Integer类型的10
        第二个Function： 将第一个function得到结果10，加上100并返回
     */
    public static void method(Function<String, Integer> one, Function<Integer, Integer> two) {
        /*

        //先通过one调用apply方法，传递字符串"10"，返回一个Integer类型的结果
        Integer num = one.apply("10");
        //通过two调用apply方法，传递one调用apply方法得到的结果，并进行处理然后返回
        Integer result = two.apply(num);

         */

        //可以对one和two进行合并，先one后two
        //先通过one调用apply方法，得到一个结果
        // 再通过two调用apply方法，此时two的apply方法参数是 one调用apply方法的结果
        //相当于 two.apply(one.apply("10"));
        Integer result = one.andThen(two).apply("10");

        System.out.println("result:" + result);
    }
}
