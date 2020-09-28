package cn.itcast.demo02_反射;
/*
    Class类中的相关方法：
    String getName​()： 获取这个类的类名（包含包的类名）
    String getSimpleName​()： 获取这个类的类名（不包含包）
    T newInstance​()： 创建这个类的对象。
 */
public class Demo02ClassMethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取类的Class对象
        Class clazz = Class.forName("cn.itcast.demo02_反射.Person");

        //String getName​()： 获取这个类的类名（包含包的类名）
        String name = clazz.getName();
        System.out.println("name:" + name);

        //String getSimpleName​()： 获取这个类的类名（不包含包）
        String simpleName = clazz.getSimpleName();
        System.out.println("simpleName:" + simpleName);

        //T newInstance​()： 创建这个类的对象。
        //因为这个clazz表示的是Person类，所以创建的是Person类的对象
        Object obj = clazz.newInstance();//这种方式创建对象是使用的空参构造创建。
        Person p = (Person)obj;
        p.setName("小明");
        p.setAge(18);
        System.out.println(p.getName() + "-" + p.getAge());
    }
}
