package cn.itcast.demo10_类的构造器引用;

public interface PersonBuilder {
    //提供一个方法，给我一个姓名和年龄，我就可以创建一个Person对象
    Person createPerson(String name, int age);
}
