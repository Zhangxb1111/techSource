package cn.itcast.demo02_反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    Class对象中保存了具体某个类的信息，因为Class对象是用来描述一个类的。
    Class 里面具有某个类构造方法，成员方法， 成员变量....

    使用反射获取到一个类中的构造方法，并且使用。
    Constructor getConstructor​(Class... parameterTypes)： 获取指定的构造方法。
                                                           参数parameterTypes表示对应构造方法的参数列表
    Constructor<?>[] getConstructors​()：获取到所有的构造方法

    上面两个方法，只能获取到public修饰的，其他权限获取不到。

    Constructor表示构造方法， 获取到构造方法之后，可以使用构造方法创建一个类的对象。
        T newInstance​(Object... initargs)： 可以根据这个构造方法创建一个对象。 并且把这个对象返回
                                             参数是调用构造方法时传递的实际参数。
 */
public class Demo03Constructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        method2();
    }

    //获取到空参的构造方法，并且使用空参数的我构造方法创建一个Person对象
    public static void method2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取到这个Class类型的对象
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //获取空参数的构造方法  Person()
        //Constructor getConstructor​(Class... parameterTypes)： 获取指定的构造方法。
        Constructor c = clazz.getConstructor();//如果小括号中不给出任何的参数，那么获取的就是空参数的构造方法。

        //使用这个构造方法创建一个Person对象
        // T newInstance​(Object... initargs)： 可以根据这个构造方法创建一个对象。
        Object obj = c.newInstance();//因为获取到的是空参数的构造方法，在调用的时候不能传递实际参数，所以这个方法不能传参
        // 转型
        Person p = (Person)obj;
        System.out.println(p.getName() + "-" + p.getAge());
    }

    //使用反射获取到所有的公共的构造方法
    //Constructor<?>[] getConstructors​()：获取到所有的构造方法
    public static void method1() throws ClassNotFoundException {
        //获取这个类的Class对象
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //获取这个类的所有的公共的构造方法
        Constructor[] cs = clazz.getConstructors();
        //遍历
        for(Constructor c : cs) {
            System.out.println(c);
        }
    }
}
