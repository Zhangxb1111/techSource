package cn.itcast.demo04_lambda作为参数和返回值;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
    Lambda表达式作为返回值
 */
public class Demo02Lambda {
    public static void main(String[] args) {
        //创建一个集合
        ArrayList<Person> list = new ArrayList<>();
        //添加元素
        list.add(new Person("周芷若", 18));
        list.add(new Person("赵敏", 16));
        list.add(new Person("金华婆婆", 17));

        //对这个集合中的Person对象按照年龄升序排序。
        Collections.sort(list, getComparator());

        System.out.println(list);
    }

    public static Comparator<Person> getComparator() {
        return (o1, o2) -> o1.getAge() - o2.getAge();
    }
}
