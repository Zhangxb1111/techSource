package cn.itcast.demo04_注解;

/*
    注解的属性

    注解的属性定义格式：
        1. 数据类型 属性名();
        2. 数据类型 属性名() default 默认值;

    注意，注解的属性只能是以下数据类型
       1. 八种基本类型。 byte short int long float double char boolean
       2. String Class 枚举 注解类型
       3. 以上数据类型的一维数组

    在使用注解的使用，如果注解中的属性没有默认值，那么在使用的时候必须给这个注解赋上值
    如果这个注解中的属性有默认值，对于有默认值的属性，可以赋值，也可以不赋值。
    如果这个注解的属性是一个数组，那么赋值的时候，可以使用大括号把各个元素包裹起来
    如果注解的属性是一个数组，那么赋值的时候，假如这个数组只有一个元素，可以省略大括号
 */
public @interface Student {
    String name();
    int age() default 10;
    String[] hobbies();
}
