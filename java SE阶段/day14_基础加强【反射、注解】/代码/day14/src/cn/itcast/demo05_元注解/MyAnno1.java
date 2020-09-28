package cn.itcast.demo05_元注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
    Retention元注解

    Retention可以限制注解的生命周期。如果不加这个元注解，那么注解只在源代码和.class字节码文件中有效。
    在运行时期内存中是没有的。

    Retention中有一个属性RetentionPolicy value() ， 可以表示注解的声明周期
    RetentionPolicy是一个枚举类型.里面的内容如下

    RetentionPolicy.SOURCE: 表示注解只在源代码阶段有效，在.class字节码文件和运行时内存中是没有的。
    RetentionPolicy.CLASS: 表示注解在源代码阶段和.class字节码文件中有效，运行时内存是没有的。（默认）
    RetentionPolicy.RUNTIME：表示注解在源代码阶段和.class阶段和运行时阶段都是有效的。

 */
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnno1 {
}
