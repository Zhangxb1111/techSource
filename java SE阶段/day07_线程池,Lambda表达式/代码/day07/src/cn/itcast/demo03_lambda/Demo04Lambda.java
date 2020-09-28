package cn.itcast.demo03_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    使用比较器排序对存放Person对象的集合按照Person对象的年龄进行升序排序。
 */
public class Demo04Lambda {
    public static void main(String[] args) {
        //创建集合
        ArrayList<Person> list = new ArrayList<>();
        //添加Person对象
        list.add(new Person("小月月", 10));
        list.add(new Person("小幂幂", 8));
        list.add(new Person("小甜甜", 9));

        //使用比较器排序根据年龄进行排序
        //Collections.sort(list, new Rule());

        //使用匿名内部类
        /*
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                //升序 o1 - o2
                return o1.getAge() - o2.getAge();
            }
        });
        */

        //使用Lambda表达式
        /*
        Collections.sort(list, (Person o1, Person o2) -> {
            return  o1.getAge() - o2.getAge();
        });
        */

        //使用简化版的lambda表达式
        Collections.sort(list, (o1, o2) -> o1.getAge() - o2.getAge());


        //打印
        System.out.println("list:" + list);

    }
}
