package cn.itcast.demo02_反射;
/*
    获取一个类的Class对象的三种方式

    1. 通过对象调用getClass获取
        Class getClass()
    2. 通过类名.class的方式获取
    3. 通过Class的静态方法forName获取
        static Class forName​(String className): 根据类名获取到对应的Class对象

        传递的类名一定要是全类名（包含包的类名）

    每个类的Class类型的对象只有一个，所以说不管怎么获取这个类的Class对象，那么获取的永远是同一个。
 */
public class Demo01Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. 通过对象调用getClass获取
        Person p = new Person();
        Class clazz1 = p.getClass();
        System.out.println(clazz1);

        //2. 通过类名.class的方式获取
        Class clazz2 = Person.class;
        System.out.println(clazz2);

        //3. 通过Class的静态方法forName获取
        Class clazz3 = Class.forName("cn.itcast.demo02_反射.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true
    }
}
