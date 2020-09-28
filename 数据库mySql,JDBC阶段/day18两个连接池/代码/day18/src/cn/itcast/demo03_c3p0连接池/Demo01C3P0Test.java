package cn.itcast.demo03_c3p0连接池;

import cn.itcast.jdbcutils.JDBCUtils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo01C3P0Test {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        Connection con = C3P0Utils.getConnection();
        System.out.println(con);
    }
}
