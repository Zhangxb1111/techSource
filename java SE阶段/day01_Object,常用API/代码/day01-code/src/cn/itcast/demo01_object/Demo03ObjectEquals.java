package cn.itcast.demo01_object;
/*
    如果使用==比较引用类型，比较的是地址值。

    如果想要比较对象的内容，可以使用equals方法（Object中）
    当通过一个对象调用equals方法，会先看一下自己有没有，如果自己没有，就向上找父类一直到Object

    在Object中的equals方法，默认是使用==比较的地址值。

    如果想要自己定义比较的规则，可以在子类中重写equals方法，在equals方法中定义自己的规则。

 */
public class Demo03ObjectEquals {
    public static void main(String[] args) {
        //创建三个Person对象
        Person p1 = new Person("王宝强", 18);
        Person p2 = new Person("贾乃亮", 20);
        Person p3 = new Person("贾乃亮", 20);

        //使用==进行比较
        System.out.println(p1 == p2); //false
        System.out.println(p2 == p3); //false
        System.out.println("---------------------------");

        System.out.println(p1.equals(p2)); //false
        System.out.println(p2.equals(p3)); //false


        //System.out.println(p2.equals(new Dog()));
    }
}
