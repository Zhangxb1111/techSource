package cn.itcast.demo05_exception;
/*
    try小括号中写的对象，必须是AutoCloseable接口的实现类

    try()...catch 就是 try...catch...finally的语法糖.
 */
public class Demo03Exception {
    public static void main(String[] args) {
        try(Person p = new Person()) {
            System.out.println("try...执行了");
        } catch (Exception e) {

        }
    }
}
