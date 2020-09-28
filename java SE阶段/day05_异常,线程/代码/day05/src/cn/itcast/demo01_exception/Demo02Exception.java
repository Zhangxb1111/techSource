package cn.itcast.demo01_exception;

public class Demo02Exception {
    public static void main(String[] args) {
        //定义一个数组
        int[] arr = new int[2];

        //调用getValue获取数组指定索引的元素
        int value = getValue(arr, 10);

        System.out.println("value:" + value);
    }

    /*
        用来获取数组指定索引的元素
     */
    public static int getValue(int[] arr, int index) {
        return arr[index];
    }
}
