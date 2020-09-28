package cn.itcast.demo01_exception;
/*
    throw关键字，可以手动的抛出一个异常对象。

    格式：
        throw new 异常类();

    注意：
        只有异常体系下的类才具有可抛性。
        一旦某个方法抛出异常，后面的代码都不会再执行了
 */
public class Demo03Throw {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = new int[2];

        //调用getValue获取数组指定索引的元素
        int value = getValue(arr, 10);

        System.out.println("value:" + value);
    }

    /*
        定义方法，获取数组指定索引上的元素
     */
    public static int getValue(int[] arr, int index) {
        //进行判断，如果index索引不在合法范围内，那么就手动抛出一个异常。
        if (index < 0 || index >= arr.length) {
            //如果索引是不合法的，那么我们就手动抛出一个异常
            String msg = "您的索引是不合法的， 您给的索引是：" + index + "但是数组的长度是" + arr.length;
            throw new ArrayIndexOutOfBoundsException(msg);
        }
        System.out.println("你好");
        return arr[index];
    }
}
