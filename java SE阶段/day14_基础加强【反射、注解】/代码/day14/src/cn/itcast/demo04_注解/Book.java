package cn.itcast.demo04_注解;
/*
    如果一个注解中只有一个没有默认值的注解，并且这个注解叫做value。那么在给这个属性赋值的
    时候，可以省略属性名。 反之，必须写全。
 */
public @interface Book {
    String value(); //书的名字

    int price() default 100;

    String author() default "佚名";
}
