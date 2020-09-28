package cn.itcast.demo01_sql注入攻击;

import cn.itcast.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
    模拟sql注入攻击
 */
public class Demo01JDBC {
    public static void main(String[] args) throws SQLException {
        //定义两个字符串，一个是用户名一个是密码
        Scanner sc = new Scanner(System.in);
        System.out.println("请您键盘录入用户名 ");
        String username = sc.nextLine();
        System.out.println("请您键盘录入密码");
        String password = sc.nextLine();

        //模拟登陆
        Connection con = JDBCUtils.getConnection();
        //获取sql语句执行者 对象
        Statement st = con.createStatement();
        //定义sql
        String sql = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        ResultSet rs = st.executeQuery(sql);
        //处理，只要查询到数据，那么就表示登录成功，否则就表示登录失败
        if(rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        JDBCUtils.close(con, st, rs);
    }
}
