package cn.itcast.demo07_warp;
/*
    手动拆装箱（Integer和int举例）(了解)

        int -> Integer
            可以使用Integer里面的一个静态方法转换，这个方法叫做valueOf。
            static Integer valueOf​(int i)： 将基本类型转成包装类


        Integer -> int
            调用Integer对象的成员方法，叫做intValue
            int intValue​(): 转成基本类型的int并返回

 */
public class Demo02Warp {
    public static void main(String[] args) {
        int basicNum = 50;
        //调用方法，把这个基本类型的数据转成包装类
        Integer warpNum = Integer.valueOf(basicNum);
        System.out.println(warpNum);


        int a=  warpNum.intValue();
        System.out.println(a);
    }
}
