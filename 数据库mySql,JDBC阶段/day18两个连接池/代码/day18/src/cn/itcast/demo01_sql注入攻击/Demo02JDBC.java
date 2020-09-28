package cn.itcast.demo01_sql注入攻击;

import cn.itcast.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
    如何解决sql注入攻击。

    解决sql注入攻击可以使用PreparedStatement进行预编译。
    这个接口是是Statement的子接口，所以这个接口也可以去执行sql语句。

    PreparedStatement 可以对sql语句进行预编译（预先把sql保存起来等以后再执行），
    PreparedStatement他的效率相对来说也要高一些
    PreparedStatement 可以过滤掉sql语句中的关键字.

    之前获取sql语句执行者对象
        Statement st = con.createStatement();
    现在因为要对sql语句进行预编译，所以要使用另外的方法。（Connection中的方法）
        PreparedStatement prepareStatement​(String sql)： 对sql语句进行预编译，并返回PreparedStatement对象

    在预编译的sql语句中，会动态改变的部分要使用? 占位符替换。

 */
public class Demo02JDBC {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请您键盘录入用户名");
        String username = sc.nextLine();
        System.out.println("请您键盘录入一个密码");
        String password = sc.nextLine();

        //获取一个连接
        Connection con = JDBCUtils.getConnection();

        //对sql语句进行预编译
        //在预编译的sql语句中，会动态改变的部分要使用? 占位符替换。
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        //执行sql语句前，一定要把所有的?占位符都替换成实际的参数
        //在PreparedStatement里面有一个方法，叫做setXXX(索引, 实际数据)， 可以使用这个方法替换问号占位符
        //可以直接调用setObject方法使用实际的数据替换问号占位符（设置参数）
        pst.setObject(1, username);//表示使用jack替换掉第一个?
        pst.setObject(2, password);

        //开始执行了
        ResultSet rs = pst.executeQuery();// 因为在预编译的时候已经把sql语句预先保存起来了，所以执行查询的时候不需要传递sql语句
        //判断是否有数据
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        JDBCUtils.close(con, pst, rs);

    }
}
