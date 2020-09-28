package cn.itcast.demo04_objectstream;

import java.io.Serializable;
/*
    Serializable这个接口中没有任何方法。这个接口只是做一个标记。
    只有实现这个接口的类的对象，才能被序列化。


    如何给类分配一个固定不变的版本号（序列号）
    在类的成员位置提供一个long类型的静态常量即可，这个静态常量必须叫做serialVersionUID
 */
public class Person implements Serializable{
    //给这个类分配一个固定的版本号，不管这个类的内容怎么修改，类的版本号永远是0
    private static final long serialVersionUID = 0L;
    private String name;
    private /*static*/ /*transient*/ int age;

    public void sleep() {

    }

    public Person() {
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
