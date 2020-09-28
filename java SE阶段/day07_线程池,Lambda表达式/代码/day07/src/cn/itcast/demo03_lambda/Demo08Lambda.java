package cn.itcast.demo03_lambda;
/*
    Lambda表达式的标准格式：
    (参数类型 参数名) -> {
        方法体;
        return 返回值;
    }

    省略规则：
        1. 小括号中的参数类型可以省略。
        2. 如果小括号中只有一个参数，那么小括号也可以省略。
        3. 如果大括号中只有一个语句，俺么不管这个方法有没有返回值，都可以省略大括号return以及分号。

    Lambda表达式的使用前提：
        1. 必须有接口。并且接口中有且仅有一个需要被重写的抽象方法。 （这种接口叫做函数式接口）
        2. 必须支持上下文推导。方法参数要是接口类型。或者 使用一个接口类型的变量接收Lambda。


    Lambda表达式能否完全替换匿名内部类， 不能。
        1. 匿名内部类可以是普通类，抽象类，以及接口。 Lambda表达式只支持接口。
        2. 匿名内部类可以重写多个方法。 Lambda表达式要求只有一个方法。

    Lambda表达式的原理和匿名内部类完全不同。
    Lambda表达式不是匿名内部类的语法糖。

    Lambda表达式是使用的动态的字节码指令。 invokedynamic

    匿名内部类用的是静态的字节码指定。 invokestatic invokeinterface........



 */
public class Demo08Lambda {
    public static void method(Cook cook) {
        cook.makeFood();
    }

    public static void main(String[] args) {
        method(() -> {
            System.out.println("吃饭饭");
        });

        Cook cook = () -> {
            System.out.println("吃饭饭");
        };
    }
}
