package cn.itcast.demo02_反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    反射获取Person的get/set方法，并且使用
 */
public class Demo08Method {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取这个类的Class类型的对象
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //通过这个类的Class创建一个Person对象
        Object obj = clazz.newInstance();

        //使用反射获取到这个Person类的setName方法，给姓名赋值
        Method m = clazz.getMethod("setName", String.class);
        //调用这个方法，给obj的姓名属性赋值
        m.invoke(obj, "大幂幂");

        //使用反射获取到Perosn类的getName方法，通过调用get方法获取姓名并打印
        Method m2 = clazz.getMethod("getName");
        Object result = m2.invoke(obj);
        System.out.println(result);
    }
}
