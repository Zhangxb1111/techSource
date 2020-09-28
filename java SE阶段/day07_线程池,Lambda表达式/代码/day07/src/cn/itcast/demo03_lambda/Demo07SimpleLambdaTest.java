package cn.itcast.demo03_lambda;

public class Demo07SimpleLambdaTest {
    public static void method(Cook cook) {
        cook.makeFood();
    }

    public static void main(String[] args) {
        //使用Lambda标准格式进行调用
        method(() -> {
            System.out.println("使用Lambda标准格式吃饭饭， 不好吃");
        });

        //使用Lambda省略格式进行调用

        method(() -> System.out.println("使用Lambda省略格式吃饭饭， 香香哒"));
    }
}
