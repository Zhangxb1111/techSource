package cn.itcast.demo07_注解练习;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    查看MyTestDemo中哪些方法有@TEst注解，如果有，就直接运行这个方法
 */
public class Demo01Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取MyTestDemo对应的Class
        Class clazz = MyTestDemo.class;

        //获取里面的所有方法
        Method[] methods = clazz.getMethods();

        //遍历这个数组，拿到每一个方法，判断上面是否@MyTest注解，如果有，就运行
        for (Method method : methods) {
            boolean flag = method.isAnnotationPresent(MyTest.class);//判断方法上有没有MyTest注解
            //判断
            if (flag) {
                //如果有注解，那么就运行这个方法
                Object obj = clazz.newInstance();
                method.invoke(obj);
            }
        }
    }
}
