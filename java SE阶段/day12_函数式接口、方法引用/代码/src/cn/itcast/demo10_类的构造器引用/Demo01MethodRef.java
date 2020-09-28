package cn.itcast.demo10_类的构造器引用;
/*
    类的构造器引用

    类名::new
 */
public class Demo01MethodRef {
    public static void main(String[] args) {
        //method((name, age) -> new Person(name, age));

        method(Person::new);
    }

    public static void method(PersonBuilder personBuilder) {
        Person person = personBuilder.createPerson("张无忌", 18);
        System.out.println(person);
    }
}
