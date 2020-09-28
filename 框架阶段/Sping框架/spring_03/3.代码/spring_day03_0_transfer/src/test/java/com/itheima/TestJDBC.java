package com.itheima;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

    public void test(){

        String sql = "";

        Connection conn = null;
        try {
            conn.setAutoCommit(false); //设置手动提交事务
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            stm.executeUpdate(sql);
            conn.commit(); //提交事务
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback(); //回顾
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
