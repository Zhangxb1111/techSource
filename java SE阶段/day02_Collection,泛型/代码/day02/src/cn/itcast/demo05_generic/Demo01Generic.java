package cn.itcast.demo05_generic;

import java.util.ArrayList;
/*
    注意：
    泛型之间没有继承关系。
    ArrayList<Person> 并不是 ArrayList<Student> 的父类。

    如果想要让方法的参数集合能够接受任意类型的泛型，可以使用泛型通配符。

    泛型通配符是?表示，表示可以接收匹配任何类型的泛型。

    注意：
        泛型通配符只能被动匹配，不能主动使用。
 */
public class Demo01Generic {
    public static void main(String[] args) {
        //创建一个集合
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("小苍同学", 12));
        list.add(new Student("小泽同学", 18));
        list.add(new Student("小波同学", 18));//波多尔斯基

        //调用方法，遍历存放学生的集合
        printArrayList(list);
        System.out.println("---------------------------------");
        ArrayList<Teacher> list2 = new ArrayList<>();
        list2.add(new Teacher("小野老师", 19));
        printArrayList(list2);

        System.out.println("---------------------------------");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("aaa");
        printArrayList(list3);

    }

    /*
        定义方法，接收集合类型的参数，集合的泛型可以是任何类型
     */
    public static void printArrayList(ArrayList<?> list) {//?表示可以匹配任何类型的泛型
        //对list集合进行遍历
        for (Object obj : list) {
            //把obj强转成Person。
            Person p = (Person)obj;
            System.out.println(p);
        }
    }

    /*
        定义一个方法，既能遍历存放老师的集合，又能遍历存放学生的集合.
     */
    /*
    public static void printArrayList(ArrayList<Person> list) {
        //遍历打印
        for(Person p : list) {
            System.out.println(p);
        }
    }
    */

    /*
        定义方法，遍历存放老师的集合
     */
    /*
    public static void printArrayList(ArrayList<Teacher> list) {//泛型只在编译时期有效，所以这个方法参数和下面方法一模一样

    }
    */
    /*
        定义方法，用来遍历存放学生的集合
     */
    /*
    public static void printArrayList(ArrayList<Student> list) {
        //遍历打印
        for(Student stu : list) {
            System.out.println(stu);
        }
    }
    */
}
