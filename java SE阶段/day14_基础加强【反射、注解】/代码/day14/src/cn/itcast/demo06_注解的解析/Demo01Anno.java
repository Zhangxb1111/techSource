package cn.itcast.demo06_注解的解析;

import java.lang.annotation.Annotation;

/*
    注解的解析

    注解解析就是获取注解中的信息，比如获取注解中的属性。

    解析相关的API
        Annotation接口： 是所有注解的根接口。所有注解都默认实现了这个接口

        AnnotatedElement： 是一个接口，可以对注解进行操作。
            boolean isAnnotationPresent​(Class annotationClass)： 判断是否有注解。 参数是注解的Class对象
            Annotation[] getAnnotations​()：获取所有的注解.可以获取继承下来的
            Annotation[] getDeclaredAnnotations​()： 获取所有的注解。
            <T extends Annotation>T getAnnotation​(Class annotationClass)： 获取指定的注解。 参数是Class类型的对象，表示对应注解的Class

       Class实现了AnnotatedElement接口， 所以类的Class中是有这个接口中的方法的
       反射有关的类都实现了这个接口，比如Field，Constructor，Method

    注解解析要通过反射技术。
    如果要获取类上面的注解，就通过Class对象调用方法
    如果要获取方法上的注解，就通过Method对象调用放啊福
 */
public class Demo01Anno {
    public static void main(String[] args) {
        //先获取到这个BookStore对应的Class对象
        Class clazz = BookStore.class;

        //判断这个类上是否有注解
        boolean flag = clazz.isAnnotationPresent(Book.class);//判断这个类上面是否有Book注解
        if(flag) {
            //如果这个类上面有这个注解，那么我们就获取到这个注解
            Annotation anno = clazz.getAnnotation(Book.class);// 获取的Book注解
            //向下转型
            Book book = (Book)anno;
            //打印这个注解的水薛佳凝
            System.out.println(book.value());
            System.out.println(book.price());
            System.out.println(book.author());
        }
    }
}
