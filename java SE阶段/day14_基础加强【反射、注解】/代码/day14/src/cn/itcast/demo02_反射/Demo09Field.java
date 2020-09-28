package cn.itcast.demo02_反射;

import java.lang.reflect.Field;

/*
    反射操作成员变量（了解）

    可以通过Class对象的以下几个方法来获取一个类中的成员变量
        Field getField​(String name)： 获取指定的成员变量，参数为成员变量的名字
        Field[] getFields​()： 获取所有的成员变量。

        注意： 上面两个方法，只能获取到public修饰的成员变量，其他权限获取不到。

    Field 表示的是成员变量
        void set​(Object obj, Object value)： 给对象的成员变量赋值
                参数obj： 表示给哪个对象赋值
                参数value： 表示赋值什么
        Object get​(Object obj)：获取成员变量的值。
                参数obj：表示获取的这个对象的此成员变量的值
 */
public class Demo09Field {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        method2();
    }

    //获取Person类中指定的成员变量。 city，并且给这个成员变量赋值然后获取值
    public static void method2() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        //获取这个类对应的Class
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //拿到里面的city这个成员变量
        Field field = clazz.getField("city");

        //创建Person的对象
        Object obj = clazz.newInstance();
        //给这个成员变量赋值
        field.set(obj, "北京");//给obj的city属性赋值，赋值成"北京"

        //获取这个成员变量的值
        Object result = field.get(obj);//表示获取的是obj这个对象的city属性
        System.out.println("result:" + result);
    }

    //获取到Person类中的所有的成员变量
    public static void method1() throws ClassNotFoundException {
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");
        //调用getFields获取这个类中的所有的成员变量
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}
