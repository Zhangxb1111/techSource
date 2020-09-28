package cn.itcast.demo03_lambda延迟执行;
/*
    定义一个方法，接口两个参数，一个是日志等级， 一个是日志信息。
    在这个方法内判断，如果日志等级是1，就打印日志信息。

    步骤：
        1. 会将a b c三个字符进行拼接，然后当做method方法的参数传递过去。
        2. 在method方法中进行判断，如果满足等级要求，就打印
           如果不满足要求，就不打印。

    存在的问题：
        如果条件成立，就打印。 但是如果条件不成立，那么就不会打印，但是之前以及把这三个字符串
        拼接好了，所以此时会造成性能浪费。
 */
public class Demo01Lambda {
    public static void main(String[] args) {
        String a = "hello";
        String b = "world";
        String c = "java";
        //调用method方法，传递日志
        method(3, a + b + c);
    }

    /*
        如果日志等级满足要求，就打印日志信息
     */
    public static void method(int level, String msg) {
        if(level == 1) {
            System.out.println(msg);
        }
    }
}
