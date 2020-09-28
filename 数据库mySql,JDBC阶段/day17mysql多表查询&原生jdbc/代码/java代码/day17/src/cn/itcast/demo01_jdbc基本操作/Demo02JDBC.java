package cn.itcast.demo01_jdbc基本操作;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    jdbc 的开发步骤：
        1. 注册驱动
        2. 获取连接
        3. 获取Sql语句的执行者对象。
        4. 执行sql语句。
        5. 处理结果集（ 只有查询需要处理，增删改操作不需要处理）
        6. 释放资源
 */
public class Demo02JDBC {
    public static void main(String[] args) throws SQLException {
        //1. 注册驱动
        //注册驱动需要使用DriverManager去完成，可以调用这个类中的一个方法
        //static void registerDriver​(Driver driver)
        //参数是一个Driver接口，我们要传递实现类对象，实现类在驱动jar中。
        //要使用哪种数据库，就传递哪个驱动jar中的实现类。
        //mysql驱动jar中的com.mysql.jdbc.Driver这个类就实现了这个接口
        DriverManager.registerDriver(new Driver());

        //2. 获取连接
        //获取连接也是通过DriverManager这个类里面的方法去获取
        //static Connection getConnection​(String url, String username, String password)： 去数据库进行连接，并获取到对应的连接
        //参数url：连接数据库的字符串，有固定写法：   jdbc:mysql://数据库的ip地址:端口号/数据库名
        //参数username：连接数据库对应的用户名
        //参数password： 连接书库对应的密码
        //返回值Connection对象，表示数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/mydb";
        String username = "root";
        String password = "sorry";
        Connection con = DriverManager.getConnection(url, username, password);

        //3. 获取Sql语句的执行者对象。
        //获取sql语句执行者对象需要通过连接对象（Connection）去调用方法获取
        //Statement createStatement​()  可以获取到一个sql语句的执行者对象，这个只执行者对象用于执行sql
        //返回值 Statement 表示sql语句的执行者对象
        Statement st = con.createStatement();

        //4. 执行sql语句。
        String sql = "INSERT INTO product (pname, price, flag) VALUES ('劲霸', 100, '1')";
        //使用Statement sql语句执行者对象去执行sql
        //调用里面的方法
        //int executeUpdate​(String sql)： 执行增删改语句，返回影响的行数 不能执行查询。
        int row = st.executeUpdate(sql);
        System.out.println("受影响的行数是：" + row);

        //5. 处理结果集，增删改操作不需要处理，所以省略
        //6. 释放资源
        //sql语句执行者对象需要释放
        //连接对象需要释放
        st.close();
        con.close();
    }
}
