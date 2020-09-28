package cn.itcast.demo01_object;
/*
    在Object中，有一个方法，叫做toString，可以把一个对象转成对应的字符串形式。
    String toString​() 返回对象的字符串表示形式。

    当通过一个对象调用toString方法后，会先看一下自己有没有这个方法，如果没有就向上找父类，一直到Object
    Object中的tostring方法，默认显示的地址值。

    当直接打印一个对象时，内部也会调用它的toString方法进行打印。

    Object中的toString显示的是地址值，这个地址值对于我们来说一般没有意义。
    如果想要得到我们自己需要的内容，可以在子类中重写toString。
 */
public class Demo02ObjectToString {
    public static void main(String[] args) {
        //创建一个Person对象
        Person p = new Person("张三丰", 88);

        System.out.println(p.toString());

        System.out.println(p);
    }
}
