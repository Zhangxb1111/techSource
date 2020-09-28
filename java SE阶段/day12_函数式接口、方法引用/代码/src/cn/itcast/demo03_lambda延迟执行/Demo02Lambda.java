package cn.itcast.demo03_lambda延迟执行;

/*
    Lambda表达式延迟执行
    lambda表达式会在接口调用它对应的抽象方法的时候执行。
 */
public class Demo02Lambda {
    public static void main(String[] args) {
        String a = "hello";
        String b = "world";
        String c = "java";

        method(3, () -> a + b + c );
    }

    public static void method(int level, MessageBuilder messageBuilder) {
        if(level == 1) {
            System.out.println(messageBuilder.createMessage());
        }
    }
}
