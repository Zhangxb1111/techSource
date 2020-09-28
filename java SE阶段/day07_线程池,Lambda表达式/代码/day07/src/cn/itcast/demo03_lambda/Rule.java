package cn.itcast.demo03_lambda;

import java.util.Comparator;

public class Rule implements Comparator<Person>{
    //升序就是 1-2
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
