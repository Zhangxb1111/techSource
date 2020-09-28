package cn.itcast.demo01_exception;

public class Demo10Finally {
    public static void main(String[] args) {
        System.out.println(getValue());
    }

    /*
        定义方法，这个方法可以获取一个数字

        步骤：
        ·   1. 执行到try中的return i， 此时会先把要返回的结果保存起来，此时要返回的结果是0.
            2. 指定完了try之后执行到了finally代码块，在finally代码块中对i的值进行了改变，i变成了10.
            3. finally执行完之后，再返回结果，返回的是之前已经保存好的数据0.

     */
    public static int getValue() {
        int i = 0;
        try {
            return i;//0
        } catch (Exception e) {
            System.out.println("出现异常啦");
        } finally {
            i = 10;
            System.out.println("finally代码块执行啦");
        }
        return 100;
    }

}
