package cn.itcast.demo08_super引用父类的方法;

public class Student extends Person{

    public void sayHello() {
        //method(() -> System.out.println("雷猴"));

        //method(() -> super.sayHello());

        method(super::sayHello);
    }

    public void method(Greetable greetable) {
        greetable.greet();
    }
}
