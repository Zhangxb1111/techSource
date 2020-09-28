package cn.itcast.demo03_lambda;
/*
    在下面的代码中，请使用Lambda的标准格式调用 invokeCook 方法，打印输出“吃饭啦！”字样
 */
public class Demo03Lambda {

    public static void invokeCook(Cook cook) {
        cook.makeFood();
    }

    public static void main(String[] args) {
        //1. 使用匿名内部类的方式调用invokeCook方法
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("使用匿名内部类吃饭，好难吃");
            }
        });

        //2. 使用Lambda表达式实现
        //格式： () -> {}
        invokeCook(() -> {
            System.out.println("使用Lambda表达式吃饭， 真香");
        });

    }
}
