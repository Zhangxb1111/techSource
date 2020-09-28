package cn.itcast.demo02_set;
/*
    对象的哈希值

    哈希值就是一串int数字， 这串数字可以看成对象的一个特征码。

    如何获取一个对象的哈希值？
    在Object中有一个方法，叫做hashCode，可以获取到对象的哈希值。
    在Object中的hashCode的哈希值计算方式，是根据对象的地址值计算的。

    如果希望自己定义哈希值的计算规则，可以在子类中重写hashCode方法。
    重写之后的hashCode方法，里面就是我们自己的规则。

    对象的哈希值会不会重复？？
        对象的哈希值就是一个int数字， int数字取值范围42亿个。 假如有50亿个对象。

    哈希值是对象的一个特征码，一个标识，但是并不是一个唯一的标识。


    总结：
        1. 哈希值是对象的特征码，可以通过Object的hashCode方法获取到。
        2. 如果不希望使用Object里面的hashCode 的哈希值计算规则，可以在子类中重写hashCode 方法。

 */
public class Demo03HashCode {
    public static void main(String[] args) {
        //创建一个Student对象
        Student stu = new Student("狗蛋", 18);
        //获取这个对象的哈希值，并打印
        System.out.println(stu.hashCode()); //1967205423
        //System.out.println(stu); //cn.itcast.demo02_set.Student@75412c2f

        Student stu2 = new Student("狗蛋", 18);
        System.out.println(stu2.hashCode());

        Student stu3 = new Student("旺财", 18);
        System.out.println(stu3.hashCode());
    }
}
