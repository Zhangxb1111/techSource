package cn.itcast.utils;

import java.sql.*;

/*
    jdbc的工具类。

    里面提供两个方法：
        1. 用于获取一个数据库连接对象
        2. 释放资源
 */
public class JDBCUtils {

    //定义url，username，password
    private static String url = "jdbc:mysql://localhost:3306/mydb";
    private static  String username = "root";
    private static String password = "sorry";

    static {
        //注册驱动只需要执行一次，所以放在静态代码中。
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
        定义方法，用于获取数据库连接对象
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //调用DriverManager的getConnection获取一个连接对象
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }

    /*
        释放资源
     */
    public static void close(ResultSet rs, Statement st, Connection con) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if(st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
