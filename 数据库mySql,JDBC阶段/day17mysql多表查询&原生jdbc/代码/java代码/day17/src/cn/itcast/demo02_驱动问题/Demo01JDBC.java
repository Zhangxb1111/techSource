package cn.itcast.demo02_驱动问题;

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

/*
    jdbc的驱动问题

    1.我们之前的方式：DriverManager.registerDriver(new Driver())
      这种方式注册驱动会注册两次，因为在new Driver的时候，会加载Driver类，加载Driver类
      会执行Driver的静态代码块。在静态代码块中也会有一个注册驱动的代码去注册驱动。

    2. 现在要求的方式： Class.forName("com.mysql.jdbc.Driver");
       Class.forName的作用是将这个类加载到内存中，将这个类加载到内存，肯定会执行这个类的
       静态代码块，在静态代码块中注册驱动，只会注册一次

 */
public class Demo01JDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //之前的方式，会注册两次
        //DriverManager.registerDriver(new Driver());

        //现在的方式
        Class.forName("com.mysql.jdbc.Driver");
    }
}
