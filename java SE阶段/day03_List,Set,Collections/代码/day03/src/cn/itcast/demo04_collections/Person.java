package cn.itcast.demo04_collections;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    /*
        在排序的时候，会使用某个对象调用这个compareTo方法和另一个对象进行比较。
        返回值等于0，表示当前对象和另一个对象是相同的。
        返回值小于0，表示当前对象小于指定的对象
        返回值大于0，表示当前对象大于指定的对象。
        口诀
        升序就是我减他，降序就是他减我
     */
    @Override
    public int compareTo(Person o) {
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
