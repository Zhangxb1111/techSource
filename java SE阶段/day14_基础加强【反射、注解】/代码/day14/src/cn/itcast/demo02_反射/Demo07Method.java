package cn.itcast.demo02_反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    反射获取有参的成员方法并使用

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
public class Demo07Method {
    //反射获取Person类中的 sleep(String address, int time) 并且对他进行调用
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取Person类对应的Class对象
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //获取到Person类中指定的成员方法
        //sleep(String address, int time)
        //表示获取的方法方法名是sleep，这个方法有两个参数，第一个参数是String，第二个参数是int
        Method m = clazz.getMethod("sleep", String.class, int.class);
        //调用invoke方法，让这个sleep方法去执行。
        Object obj = clazz.newInstance();
        //表示使用obj调用sleep方法，参数传递"301教室", 3
        //相当于 obj.sleep("301教室", 3);
        m.invoke(obj, "301教室", 3);

    }
}
