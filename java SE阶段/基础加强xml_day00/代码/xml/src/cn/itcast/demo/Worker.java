package cn.itcast.demo;

public class Worker {
    private String name;
    private String sex;

    public Worker() {
    }

    public Worker(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Worker{" +
               "name='" + name + '\'' +
               ", sex='" + sex + '\'' +
               '}';
    }
}
