package cn.itcast.demo06_注解的解析;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Book {
    String value(); //书名
    int price() default 100;//价格
    String author(); //作者
}
