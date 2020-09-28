package cn.itcast.demo03_lambda;
//在下面的代码中，请使用Lambda的标准格式调用 invokeCalc 方法，完成120和130的相加计算：
public class Demo05Lambda {

    public static void invokeCalc(int a, int b, Calculate calculate) {
        int result = calculate.calc(a, b);
        System.out.println("result:" + result);
    }

    public static void main(String[] args) {
        //使用匿名内部类调用invokeCalc方法
        invokeCalc(120, 130, new Calculate() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        System.out.println("-------------------");

        //使用Lambda表达式调用invokeCalc方法
        invokeCalc(120, 130, (int a, int b) -> {
            return a + b;
        });
    }
}
