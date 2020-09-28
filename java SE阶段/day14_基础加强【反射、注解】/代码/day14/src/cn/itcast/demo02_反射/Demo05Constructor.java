package cn.itcast.demo02_反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    暴力反射。 可以拿到私有的成员并且使用。（不推荐， 会破坏封装性）

    获取构造方法：
        Constructor getDeclaredConstructor​(Class... parameterTypes)：获取指定的构造方法。这个构造方法可以是任意修饰符，包括私有
        Constructor[] getDeclaredConstructors​()： 获取所有的构造方法。包括私有

    私有的虽然可以使用上面方法获取到，但是不能直接使用，因为java中有一个权限安全检查机制，私有的
    是不能直接使用的。 如果一定要用，可以取消这个权限检查。


    Constructor表示构造方法
    Method表示方法
    Filed表示成员变量。

    这三个类都一个公共的父类，叫做AccessibleObject，这个类中有一个方法，可以取消安全检查

    void setAccessible​(boolean flag)：如果参数是true表示要取消权限检查
 */
public class Demo05Constructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        method2();
    }

    //反射获取指定私有的构造方法，并且使用这个构造方法创建对象
    //Person(String name)
    public static void method2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取这个类的Class对象
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //调用方法，获取指定的构造方法
        //private Person(String name)
        Constructor c = clazz.getDeclaredConstructor(String.class);
        //获取到构造方法之后，在使用构造方法之前取消权限检查
        c.setAccessible(true);

        //使用这个构造方法创建对象
        Object obj = c.newInstance("牛郎");

        System.out.println(obj);
    }

    //反射获取所有的构造方法(包括私有)
    public static void method1() throws ClassNotFoundException {
        //获取这个类的Class
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //获取这个类中所有的构造方法
        Constructor[] cs = clazz.getDeclaredConstructors();
        //遍历
        for (Constructor c : cs) {
            System.out.println(c);
        }
    }
}
