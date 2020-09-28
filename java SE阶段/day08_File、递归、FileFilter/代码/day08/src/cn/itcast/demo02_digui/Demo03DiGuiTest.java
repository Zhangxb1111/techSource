package cn.itcast.demo02_digui;
/*
    递归求1-n的和。

    1-5和： 1 + 2 + 3 + 4 + 5
    1-4和： 1 + 2 + 3 + 4
    1-3和： 1 + 2 + 3
    1-2和： 1 + 2
    1-1和： 1

    另一种思想：

    1-5和： 5 + （1-4的和）
    1-4和： 4 +  （1-3的和 ）
    。。。
    1-1和： 1 （固定值1）

 */
public class Demo03DiGuiTest {
    public static void main(String[] args) {
        int result = getSum(5);
        System.out.println(result);
    }

    /*
        定义方法求1-n的和
     */
    public static int getSum(int num) {
        //判断如果num是1
        if (num == 1) {
            return 1;
        }
        return num + getSum(num - 1);
    }
}
