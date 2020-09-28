package cn.itcast.demo02_set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/*
    LinkedHashSet 是Set下面的另一个实现类。

    内部除了有一个哈希表之外，还有一个链表，这个链表的作用是保证有序。

    LinkedHashSet是有序的。

    Set接口是无序，但是他不能保证所有的实现类都无序。


 */
public class Demo05LinkedHashSet {
    public static void main(String[] args) {
        //创建集合
        Set<String> set = new LinkedHashSet<>();

        //添加元素
        set.add("李白");
        set.add("杜甫");
        set.add("白居易");
        set.add("李清照");
        set.add("辛弃疾");
        set.add("霍去病");

        //遍历集合
        for(String str : set) {
            System.out.println(str);
        }
    }
}
