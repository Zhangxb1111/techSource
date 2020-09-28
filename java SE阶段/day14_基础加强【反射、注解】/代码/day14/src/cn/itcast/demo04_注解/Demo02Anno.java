package cn.itcast.demo04_注解;
/*
    定义注解的格式：
        public @interface 注解名 {

        }
 */
public class Demo02Anno {


    //@Student(name = "小明", hobbies = {"抽烟", "喝酒", "洗脚"})
    @Student(name = "小明", hobbies = "洗脚", age = 50)
    public void method() {

    }
}
