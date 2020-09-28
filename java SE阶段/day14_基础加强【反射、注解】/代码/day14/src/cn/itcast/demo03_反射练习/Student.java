package cn.itcast.demo03_反射练习;
/*
    把Student对象的属性值写到配置文件中，通过读取配置文件的方式绝对Student对象的属性值
    到底是什么
 */
public class Student {
    private String name;
    private String age;
    private String gender;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
