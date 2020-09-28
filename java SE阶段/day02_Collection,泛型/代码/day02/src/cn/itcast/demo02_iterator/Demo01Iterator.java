package cn.itcast.demo02_iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    如何对集合进行遍历？

    之前根据get(索引)的方式遍历集合，并不适用于所有的集合，因为有些集合没有索引。

    有只用通用的遍历集合的方式，叫做迭代器遍历。

    迭代器就是一个遍历集合的工具，内部有一个光标，这个光标最开始指向集合的最开头。

    如何获取集合的迭代器？ 使用Collection中的方法获取就可以了
        Iterator<E> iterator​()： 得到集合的迭代器对象。

    获取到迭代器之后，如果要进行集合的遍历，还需要调用这个迭代器的其他方法。
        boolean hasNext​()： 判断当前位置还有没有元素可以获取。
        E next​()： 获取当前位置的元素，然后把光标向后移动一个位置。

    迭代器遍历的步骤：
        1. 调用集合的iterator获取到对应的迭代器对象。
        2. 调用迭代器的hashNext方法判断是否还有没有元素可以获取。
        3. 如果有元素可以获取，那么就调用next方法获取这个元素，并把光标向后移动。

 */
public class Demo01Iterator {
    public static void main(String[] args) {
        //创建一个集合对象
        Collection<String> c = new ArrayList<>();
        //添加元素
        c.add("王宝强");
        c.add("陈羽凡");
        c.add("贾乃亮");


        //使用迭代器的遍历方式对这个集合进行遍历

        //调用集合的iterator获取到对应的迭代器对象。
        Iterator<String> iterator = c.iterator();

        //使用while循环遍历这个集合
        while (iterator.hasNext()) { //条件是如果还有元素可以获取，那么就在循环中进行获取。
            //如果条件成立，表示还有元素可以获取，那么就在循环中进行获取
            String str = iterator.next();//获取当前位置的元素，并且把光标向后移动一个位置
            System.out.println(str);
        }

        /*
        //调用迭代器的hashNext方法判断是否还有没有元素可以获取。
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next()); //获取到当前位置的元素，并且把光标向后移动一个位置。

        System.out.println(iterator.hasNext());//判断当前位置是否还有元素可以获取
        System.out.println(iterator.next());//获取到当前位置的元素，并且把光标向后移动一个位置。

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());

        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        */
    }
}
