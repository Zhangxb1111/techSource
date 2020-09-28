package cn.itcast.demo03_changeparam;
/*
    可变参数： 方法参数的数量可以变化

    格式：
        修饰符 返回值类型 方法名(参数类型... 参数名) {

        }

        1. 可变参数的方法在调用的时候，可以传递任意个数字。这些数据的类型要一致。
        2. 可变参数本质是数组，按照数组的方式去使用这个可变参数就可以了
        3. 因为可变参数本质就是数组,所以调用带有可变参数的方法时也可以传数递组，。

    注意事项：
        1. 一个方法最多只能有一个可变参数.
        2. 可变参数必须放在最后一个位置。
        3. 可变参数本质就是数组，所以不能和数组构成方法的重载。
 */
public class Demo01ChangeParams {

    public static void main(String[] args) {
        //求1-5所有数字的和
        //int[] arr = {1, 2, 3, 4, 5};
        //调用getSum求和
       //int sum = getSum(arr);
        //System.out.println("sum:" + sum);

        int sum = getSum(1,2,3);
        System.out.println("sum:" + sum);

    }


    public static int getSum(int... nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        return sum;
    }


    /*
        定义方法，求任意个整数的和
     */
    /*
    public static int getSum(int[] arr) {
        //定义变量sum，用来统计所有元素的和
        int sum = 0;
        //遍历这个数组，把每一个元素加到sum上
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    */
    /*
        定义方法，用来求两个整数的和
     */
    /*
    public static int getSum(int a, int b) {
        return a + b;
    }
    */
    /*
        定义方法，求三个整数的和
     */
    /*
    public static int getSum(int a, int b,int c) {
        return a + b + c;
    }
    */
}
