package cn.itcast.demo04_lambda作为参数和返回值;
/*
    Lambda作为参数
 */
public class Demo01Lambda {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("你好")).start();
    }
}
