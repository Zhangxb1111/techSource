package cn.itcast.demo00_反馈;

import java.io.Serializable;
/*
    Studnet. Person Teacher 类 都叫做javabean

    javabean是一个普通的类，这个类要满足三个要求。

    1. 把属性私有化，提供get/set
    2. 提供空参构造。
    3. 实现Serializable （可以省略）


    static 关键字表示静态，被static修饰的成员表示他属于类的而不是属于对象。
    transient 关键字表示瞬态。 被这个关键字修饰的成员不能被序列化

    static修饰的成员 也不会被序列化。
 */
public class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

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
