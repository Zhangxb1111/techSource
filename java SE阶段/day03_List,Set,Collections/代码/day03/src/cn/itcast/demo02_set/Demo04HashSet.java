package cn.itcast.demo02_set;

import java.util.HashSet;

/*
    使用HashSet存放dog对象。
    要求，如果两个dog对象的属性值完全相同，就当做是同一个对象。

    HashSet如何判断唯一性？
        1. 先判断哈希值，哈希值不同，肯定是不同的对象，哈希值相同，不一定是同一个对象。
        2. 如果哈希值相同还要再调用equals进行判断， 如果结果是true，就是相同，如果是false就是不同的。

    如果要使用HashSet存储自定以对象，并且要保证唯一性（属性相同就是同一个对象），必须要在这个类中
    重写hashCode和equals
 */
public class Demo04HashSet {
    public static void main(String[] args) {
        //创建HashSet集合
        HashSet<Dog> set = new HashSet<>();
        //添加狗对象
        set.add(new Dog("旺财", 8));
        set.add(new Dog("阿黄", 5));
        set.add(new Dog("哮天犬", 8888));

        set.add(new Dog("哮天犬", 8888));

        //遍历Set集合
        for(Dog dog : set) {
            System.out.println(dog);
        }
    }
}
