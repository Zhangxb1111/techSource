package cn.itcast.demo04_lambda作为参数和返回值;
/*
    请自定义一个函数式接口 MySupplier ，含有无参数的抽象方法 get 得到 Object 类型的返回值。并使用该函数式
    接口分别作为方法的参数和返回值。
 */
public class Demo03Lambda {

    public static void method(MySupplier mySupplier) {
        Object obj = mySupplier.get();
        System.out.println(obj);
    }

    public static MySupplier getMySuppler() {
        return () -> "hello";
    }


    public static void main(String[] args) {
        //method(() -> "你好");

        method(getMySuppler());
    }
}
