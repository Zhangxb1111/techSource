package com.itheima.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {

    public static void main(String[] args) {
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("url","username","password");
            //设置事务不能自动提交
            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            //批处理sql语句
            statement.executeUpdate("sql");
            statement.executeUpdate("sql");
            statement.executeUpdate("sql");
            //手动提交
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                // 设置连接为自动提交 -- 还原原来状态
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
