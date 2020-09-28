package cn.itcast.demo01_单元测试;


import org.junit.Test;

/*
    单元测试可以代替掉程序中的main方法，我们有了单元测试，可以让程序从单元测试方法开始执行

    使用：
        在某个方法上面加上注解 @Test
        然后就可以直接运行这个带有 @Test 注解的这个方法。

    方法的要求：
        1. 方法一般以test开头 （软性要求）
        2. 方法必须是public，没有返回值，没有参数 （硬性要求）

    单元测试方法的使用：
        1. 选中某个带有@Test的方法，然后右键 run 方法...
        2. 选中这个类，然后右键 类...，这种方式可以运行当前类中所有带有单元测试的方法
 */
public class Demo01Test {

    @Test
    public void testFunction() {
        System.out.println("testFunction");
    }

    @Test
    public void testMethod() {
        System.out.println("testMethod...");
    }
}
