package cn.itcast.demo01_lambda回顾;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo02Lambda {
    public static void main(String[] args) {
        //创建集合，添加Person对象
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("张三丰", 50));
        list.add(new Person("灭绝师太", 40));
        list.add(new Person("金花婆婆", 45));
        //使用比较器排序对集合中的Person对象按照年龄从小到大进行排序
        /*
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        */

        Collections.sort(list, (o1, o2) -> o1.getAge() - o2.getAge());


        System.out.println("list:" + list);
    }
}
