package cn.itcast.demo07_注解练习;
//模拟的单元测试注解。

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
}
