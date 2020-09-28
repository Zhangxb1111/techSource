package cn.itcast.demo03_foreach;

import java.util.ArrayList;
import java.util.Collection;

/*
    使用增强for循环遍历集合

    格式：
        for(数据类型 变量名 : 容器) {
            //...
        }

    增强for遍历集合，本质是迭代器

    增强for的优点和缺点

    优点： 语法更加的简洁。 省略了索引的操作。
    缺点： 在循环中拿不到索引，所以如果要对索引进行操作，还需要使用普通for循环。
 */
public class Demo02Foreach {
    public static void main(String[] args) {
        //创建一个保存字符串的集合
        Collection<String> c1 = new ArrayList<>();
        //添加元素
        c1.add("张三");
        c1.add("李四");
        c1.add("王叔叔");

        //使用增强for进行遍历
        for(String str : c1) {
            System.out.println(str);//str表示的就是集合中的每个元素
        }

        //创建一个保存Person对象的集合
        Collection<Person> c2 = new ArrayList<>();
        //添加元素
        c2.add(new Person("大幂幂", 32));
        c2.add(new Person("柳岩", 35));
        c2.add(new Person("冰冰", 30));

        //使用增强for进行遍历
        for (Person p : c2) {
            System.out.println(p);
        }
    }
}
