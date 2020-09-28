package cn.itcast.demo01_object;

import java.util.Objects;

/*
    Objects中的equals方法。

    static boolean equals​(Object a, Object b)： 比较a和b是否相同。

    如果通过Objects调用equals方法，内部会通过第一个对象调用equals和第二个对象进行比较
    如果我们想要比较对象的内容，还是要在子类中重写equals
 */
public class Demo04ObjectsEquals {
    public static void main(String[] args) {
        //创建三个对象
        Teacher t1 = new Teacher("小苍老师", 35);
        Teacher t2 = new Teacher("小苍老师", 35);

        //使用Objects里面的equals方法进行比较
        System.out.println(Objects.equals(t1, t2));
        System.out.println("-------------------------");

        t1 = null;
        t2 = null;

        //System.out.println(t1.equals(t2)); // java.lang.NullPointerException
        System.out.println(Objects.equals(t1, t2)); //true
    }
}
