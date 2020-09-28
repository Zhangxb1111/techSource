package cn.itcast.demo01_单元测试;

import org.junit.*;

/*
    在单元测试中，不仅有@Test注解，还有一些其他的注解可以完成其他的作用

    @Before： 被这个注解修饰的方法，会在每次单元测试方法执行之前执行。
    @After： 被这个注解修饰的方法，会在每次单元测试方法执行之后执行。

    @BeforeClass： 这个注解修饰的方法，会在所有单元测试方法执行前执行，终身只执行一次
    @AfterClass： 个注解修饰的方法，会在所有单元测试方法执行后执行，终身只执行一次

    注意：BeforeClass和AfterClass 这两个注解修饰的方法一定要加上static
 */
public class Demo02Test {

    @BeforeClass
    public static void beforeClassMethod() {
        System.out.println("beforeClassMethod");
    }

    @AfterClass
    public static void afterClassMethod() {
        System.out.println("afterClassMethod");
    }

    @After
    public void afterMethod() {
        System.out.println("afterMethod...");
    }

    @Before
    public void beforeMethod() {
        System.out.println("beforeMethod...");
    }

    @Test
    public void testMethod() {
        System.out.println("testMethod...");
    }

    @Test
    public void testFunction() {
        System.out.println("testFunction....");
    }
}
