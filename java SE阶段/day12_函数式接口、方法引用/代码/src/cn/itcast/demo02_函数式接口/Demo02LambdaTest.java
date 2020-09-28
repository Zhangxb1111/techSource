package cn.itcast.demo02_函数式接口;
/*
    请定义一个函数式接口 Sumable ，内含抽象 sum 方法，可以将两个int数字相加返回int结果。使用该接口作为方法
    的参数，并进而通过Lambda来使用它
 */
public class Demo02LambdaTest {
    public static void method(Sumable sumable) {
        int result = sumable.getSum(10, 20);
        System.out.println(result);
    }

    public static void main(String[] args) {
        /*
        method(new Sumable() {
            @Override
            public int getSum(int a, int b) {
                return a + b;
            }
        });
        */

        //使用Lambda表达式改进
        method((a, b) -> a + b);
    }
}
