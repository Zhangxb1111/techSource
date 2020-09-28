package cn.itcast.demo03_jdbc工具测试类;

import cn.itcast.utils.JDBCUtils;

import java.sql.SQLException;

public class Demo01JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(JDBCUtils.getConnection());
        System.out.println(JDBCUtils.getConnection());
        System.out.println(JDBCUtils.getConnection());
        System.out.println(JDBCUtils.getConnection());
    }
}
