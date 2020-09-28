package cn.itcast.demo02_digui;
/*
    使用递归求阶乘

    数学中阶乘的计算方式
    5! = 5 * 4 * 3 * 2 * 1;
    4! = 4 * 3 * 2 * 1;
    3! = 3 * 2 * 1
    2! = 2 * 1
    1! = 1

    另一种思想
    5! = 5 * 4!;
    4! = 4 * 3!;
    3! = 3 * 2!;
    2! = 2 * 1!;
    1! = 1 （固定值）
 */
public class Demo02DiGuiTest {
    public static void main(String[] args) {
        int result = getJieCheng(5);
        System.out.println("result:" + result);
    }
    /*
        求阶乘的方法。
        参数num： 表示求哪个数的阶乘。
     */
    public static int getJieCheng(int num) {
        //如果num是1,1的阶乘就是固定值1，那么就直接返回1
        if (num == 1) {
            return 1;
        }
        //其他情况
        return num * getJieCheng(num - 1);
    }
}
