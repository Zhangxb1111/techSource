package cn.itcast.demo05_元注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
    Target 是一个元注解，可以限制注解的使用位置。
    如果不使用这个元注解，那么我们定义的注解在任何位置都可以使用。

    Target中有一个属性叫做value，因为叫做value所以赋值的时候可以省略属性名。
    这个属性是ElementType[]，这个属性用于表示注解的使用位置。

    ElementType是一个枚举类型，枚举是一个特殊的类，这个类中的的成员都是静态常量，并且是自己本身类型。

    在Target的value属性中，给出不同的ElementType 枚举值，那么表示这个注解使用的位置是不同的。
    ElementType.TYPE： 用在类,接口上
    ElementType.FIELD：用在成员变量上
    ElementType.METHOD： 用在方法上
    ElementType.PARAMETER：用在参数上
    ElementType.CONSTRUCTOR：用在构造方法上
    ElementType.LOCAL_VARIABLE：用在局部变量上

 */
//@Target(ElementType.TYPE) //表示注解只能用在类的上面
@Target({ElementType.TYPE, ElementType.METHOD}) //表示注解既能够用在类上又能够用在方法上
public @interface MyAnno {
}
