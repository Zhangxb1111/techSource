package cn.itcast.demo01_object;

import java.util.Objects;

/*
    所有的类都直接或者间接的继承自Object。
    如果在一个类上面没有使用extends关键字，那么这个类是继承自Object的。
 */
public class Person {
    private String name;
    private int age;

    //生成equals方法。 alt + insert

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }




    /*
    //判断对象自己的属性和传递过来的参数的属性是否完全相同，如果完全相同，那么结果就是true。
    @Override
    public boolean equals(Object obj) {
        //判断参数对象是否是null。
        if(obj == null) {
            return false;
        }

        //判断传递过来的对象是否是Person对象，如果是，才进行比较
        if (obj instanceof Person) {
            //如果是Person对象，那么我们就在里面比较这两个对象的属性是否完全相同
            //把obj向下转型成Person，因为要调用 Person的方法。
            Person p = (Person)obj;
            //比较属性是否相同
            return this.age == p.getAge() && this.name.equals(p.getName());
        }
        return false;
    }
    */

    //直接生成toString方法以及里面的内容
    //alt + insert

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    // ctrl + o 可以快捷生成重写的方法
    /*
    @Override
    public String toString() {
        return name + "--" + age;
    }
    */


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
