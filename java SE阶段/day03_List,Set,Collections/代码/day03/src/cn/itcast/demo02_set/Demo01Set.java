package cn.itcast.demo02_set;

import java.util.HashSet;
import java.util.Set;

/*
    Set 是Collection下面的另一个子接口。
    这个接口有以下的特点：
        1. 无序 （存的顺序和取的顺序不一样）
        2. 没有索引 （不能根据索引获取元素）
        3. 不能存放重复元素。

    Set接口常见的实现类：
        HashSet(最常用)， LinkedHashSet
 */
public class Demo01Set {
    public static void main(String[] args) {
        //创建一个set集合
        Set<String> set = new HashSet<>();
        //添加元素
        set.add("大幂幂");
        set.add("小甜甜");
        set.add("大冰冰");

        //1. 无序 （存的顺序和取的顺序不一样）
        //打印这个Set集合
        System.out.println("set:" + set);

        //2. 没有索引 （不能根据索引获取元素）
        //set.get(1);

        //3. 不能存放重复元素。
        set.add("大幂幂");
        System.out.println("set:" + set);
    }
}
