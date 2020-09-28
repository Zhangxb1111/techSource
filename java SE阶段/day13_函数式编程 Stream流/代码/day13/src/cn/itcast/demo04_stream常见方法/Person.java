package cn.itcast.demo04_stream常见方法;

public class Person {
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
