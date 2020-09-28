package cn.itcast.demo07_warp;
/*
    每种基本类型都有他所对应引用类型，这个引用类型也叫作包装类。

    基本类型        引用类型
    byte            Byte
    short           Short
    int             Integer（特殊）
    long            Long
    float           Float
    double          Double
    boolean         Boolean
    char            Character（特殊）

    基本类型的数据不是对象，只是一个单纯的数组，功能简单，只能做一些运算操作。
    引用类型可以创建对象，可以调用这个对象的一些方法完成一些功能。
    基本类型能做的，引用类型也能做。

    在jdk5之后，多了一个功能，叫做自动拆装箱。
    拆箱： 引用类型（包装类）转成基本类型
    装箱： 基本类型转成引用类型（包装类）
 */
public class Demo01Warp {
    public static void main(String[] args) {
        //自动把int类型的10转成了Integer类型，是装箱。
        Integer a = 10;
        //自动把int类型的20转成了Integer类型，是装箱
        Integer b = 20;
        //1. 会先把Integer类型的a和b转成int类型进行计算， 所以此时发生了拆箱的操作。
        //2. 计算出来的a和b相加的结果是int类型， 把这个int类型的结果赋值给Integer，发生了装箱的操作。
        Integer sum = a + b;
        System.out.println(sum);
    }
}
