package cn.itcast.demo02_反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    反射获取成员方法并使用。

    如果想要获取一个类的成员方法，可以使用Class类中的这几个方法：
        Method getMethod​(String name, Class... parameterTypes)： 获取指定的成员方法
                参数name：表示要获取的成员方法的名字。
                参数parameterTypes： 是要获取的成员方法的参数列表。

       Method[] getMethods​()： 获取所有的成员方法。

       上面两个方法，只能获取public修饰的成员方法，其他权限的成员方法是获取不到的

   Method 表示的就是类中的方法。 我们可以调用Method中的一些方法完成一些功能
        Object invoke​(Object obj, Object... args): 让此方法去执行。
                参数obj：表示通过哪个对象调用此方法。
                参数args：　表示调用这个成员方法时传递的实际参数。
                返回值： 是方法调用之后的返回值
 */
public class Demo06Method {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        method2();
    }

    //获取Person类中指定的成员方法，并且调用
    public static void method2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取到这个类的Class对象
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //调用方法，获取到这个类中的指定的成员方法
        //public void eat()
        Method method = clazz.getMethod("eat"); //获取的是eat方法，并且这个eat方法没有参数

        //创建一个Person对象
        Object obj = clazz.newInstance();

        //让这个方法去执行
        method.invoke(obj);

        //obj.eat();
    }

    //获取Person类中所有的公共的成员方法
    public static void method1() throws ClassNotFoundException {
        //获取到这个类的Class对象
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //调用方法，获取到这个类的所有的成员方法
        Method[] methods = clazz.getMethods();
        //遍历打印
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
