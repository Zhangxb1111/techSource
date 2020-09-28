package cn.itcast.demo02_函数式接口;
/*
    请定义一个函数式接口 Eatable ，内含抽象 eat 方法，没有参数或返回值。使用该接口作为方法的参数，并进而
    通过Lambda来使用它。


    Lambda表达式是作为接口中抽象方法的内容存在的
 */
public class Demo01LambdaTest {
    public static void method(Eatable eatable) {
        eatable.eat();
    }

    public static void main(String[] args) {
        //使用匿名内部类  吃
        method(new Eatable() {
            @Override
            public void eat() {
                System.out.println("使用匿名内部类吃饭饭， 很难吃");
            }
        });

        //使用Lambda表达式 吃
        method(() -> System.out.println("使用Lambda表达式吃饭饭， 真香！！！"));
    }
}
