package cn.itcast.demo01_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
    Collection 是所有单列集合的根接口。

    里面有一些方法：
        public boolean add(E e) ： 把给定的对象添加到当前集合中。
        public void clear() :清空集合中所有的元素。
        public boolean remove(E e) : 把给定的对象在当前集合中删除。
        public boolean contains(E e) : 判断当前集合中是否包含给定的对象。
        public boolean isEmpty() : 判断当前集合是否为空。
        public int size() : 返回集合中元素的个数。
        public Object[] toArray() : 把集合中的元素，存储到数组中

    Collection 没有get(索引)方法， 因为不是所有集合都有索引。
 */
public class Demo01CollectionMethod {
    public static void main(String[] args) {
        method7();
    }

    //public Object[] toArray() : 把集合中的元素，存储到数组中
    public static void method7() {
        //创建集合
        Collection<String> c = new ArrayList<>();
        //添加
        c.add("爱因斯坦");
        c.add("爱迪生");
        c.add("爱德华");
        //打印集合
        System.out.println("c:" + c);
        //把集合转成数组
        Object[] objs = c.toArray();
        System.out.println("objs:" + Arrays.toString(objs));
    }

    //public int size() : 返回集合中元素的个数。
    public static void method6() {
        Collection<String> c = new ArrayList<>();
        //添加
        c.add("爱因斯坦");
        c.add("爱迪生");
        c.add("爱德华");
        //打印集合的长度
        System.out.println(c.size());
    }

    //public boolean isEmpty() : 判断当前集合是否为空。
    public static void method5() {
        Collection<String> c = new ArrayList<>();
        //添加
        c.add("爱因斯坦");
        c.add("爱迪生");
        c.add("爱德华");
        //判断是否是空
        System.out.println(c.isEmpty()); //false
        System.out.println("清除集合中的内容");
        c.clear();
        System.out.println(c.isEmpty()); //true
    }

    //public boolean contains(E e) : 判断当前集合中是否包含给定的对象。
    public static void method4() {
        Collection<String> c = new ArrayList<>();
        //添加
        c.add("爱因斯坦");
        c.add("爱迪生");
        c.add("爱德华");
        //打印集合
        System.out.println("c:" + c);
        //判断这个集合中是否包含指定的元素
        boolean flag = c.contains("爱迪生");
        System.out.println("flag：" + flag);
    }

    //public boolean remove(E e) : 把给定的对象在当前集合中删除。
    public static void method3() {
        Collection<String> c = new ArrayList<>();
        //添加
        c.add("爱因斯坦");
        c.add("爱迪生");
        c.add("爱迪生");
        c.add("爱德华");
        //打印
        System.out.println("c:" + c);
        //删除集合中的爱迪生
        c.remove("爱迪生"); //  注意，只会删除第一个爱迪生
        System.out.println("c:" + c);
    }

    //public void clear() :清空集合中所有的元素。
    public static void method2() {
        Collection<String> c = new ArrayList<>();
        //添加
        c.add("爱因斯坦");
        c.add("爱迪生");
        c.add("爱德华");
        //打印集合
        System.out.println("c:" + c);
        System.out.println("-----------------------");
        //清除这个集合
        c.clear();
        System.out.println("c:" + c);
    }

    //public boolean add(E e) ： 把给定的对象添加到当前集合中 。
    public static void method1() {
        Collection<String> c = new ArrayList<>();
        //添加
        c.add("爱因斯坦");
        c.add("爱迪生");
        c.add("爱德华");

        //打印
        System.out.println(c);
    }

}
