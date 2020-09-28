package cn.itcast.demo05_system;
/*
    统计for循环执行10000次的时间。

    步骤：
        1. 执行for循环之前记录一下当前操作系统的时间
        2. 执行for循环
        3. 执行for循环之后记录一下当前操作系统的时间
        4. 相减。
 */
public class Demo02SystemTest {
    public static void main(String[] args) {
        //1. 执行for循环之前记录一下当前操作系统的时间
        long start = System.currentTimeMillis();

        //2. 执行for循环
        for(int i = 1; i <= 10000; i++) {
            System.out.println(i);
        }

        //3. 执行for循环之后记录一下当前操作系统的时间
        long end = System.currentTimeMillis();

        System.out.println("-----------------");
        //相减
        System.out.println(end - start);
    }
}
