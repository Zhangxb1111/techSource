package cn.itcast.demo12_常用的函数式接口;

import java.util.function.Supplier;

/*
    使用函数式接口Supplier求数组元素的最大值
 */
public class Demo02SupplierTest {
    public static void main(String[] args) {
        //定义一个int数组
        int[] arr = {5, -10, 66, 43, 2};

        //调用method，求最大值
        method(() -> {
            //定义参照物，保存数组最大的值，最开始可以把索引为0的元素看成是最大的
            int max = arr[0];
            //遍历数组，拿数组中的每一个元素和max进行比较。如果比max大，就赋值给max。
            for(int i = 1; i < arr.length; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        });
    }

    //获取到数组的最大值
    public static void method(Supplier<Integer> supplier) {
        Integer result = supplier.get();
        System.out.println(result);
    }
}
