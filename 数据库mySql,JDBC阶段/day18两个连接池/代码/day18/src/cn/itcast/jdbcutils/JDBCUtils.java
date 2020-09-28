package cn.itcast.jdbcutils;

import java.sql.*;

public class JDBCUtils {
    //准备url username password
    private static String url = "jdbc:mysql://localhost:3306/mydb";
    private static String username = "root";
    private static String password = "sorry";

    static {
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //工具类中的方法，用于获取连接
    public static Connection getConnection() throws SQLException {
        //获取连接并返回
        return DriverManager.getConnection(url, username,password);
    }

    public static void close(Connection con, Statement st) {
        close(con, st, null);
    }


    //释放资源
    public static void close(Connection con, Statement st, ResultSet rs) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
