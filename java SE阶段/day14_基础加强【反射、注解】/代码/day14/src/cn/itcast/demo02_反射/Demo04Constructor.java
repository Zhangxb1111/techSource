package cn.itcast.demo02_反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    反射获取有参构造并使用

    使用反射获取到一个类中的构造方法，并且使用。
    Constructor getConstructor​(Class... parameterTypes)： 获取指定的构造方法。
                                                           参数parameterTypes表示对应构造方法的参数列表
    Constructor<?>[] getConstructors​()：获取到所有的构造方法

    上面两个方法，只能获取到public修饰的，其他权限获取不到。

    Constructor表示构造方法， 获取到构造方法之后，可以使用构造方法创建一个类的对象。
        T newInstance​(Object... initargs)： 可以根据这个构造方法创建一个对象。 并且把这个对象返回

                                            参数是调用构造方法时传递的实际参数。
     任何类型都有.class属性，包括基本数据类型
 */
public class Demo04Constructor {
    //使用反射获取到有参构造并且使用

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //先获取这个类的Class类型的对象
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //通过这个类的Class对象获取到构造方法
        //Person(String name, int age)
        Constructor c = clazz.getConstructor(String.class, int.class);//表示要获取的构造方法的第一个参数是String类型，第二个参数是int类型

        //通过这个构造方法创建一个Person对象
        Object obj = c.newInstance("小明", 12);//使用这个构造方法时，传递的第一个实际参数是小明，第二个实际参数是12
        System.out.println(obj);
    }
}
