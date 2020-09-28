package cn.itcast.demo02_preparestatemet预处理;

import cn.itcast.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
    使用PreparedStatement查询所有数据
 */
public class Demo01JDBC {
    public static void main(String[] args) throws SQLException {
        //获取一个连接对象
        Connection con = JDBCUtils.getConnection();

        //获取PreparedStatement对象，并且对sql语句进行预编译
        String sql = "SELECT * FROM product";
        PreparedStatement pst = con.prepareStatement(sql);

        //执行sql
        ResultSet rs = pst.executeQuery();

        //处理
        while(rs.next()) {
            System.out.println(rs.getObject("pid") + "\t" +
                    rs.getObject("pname") + "\t" +
                    rs.getObject("price") + "\t" +
                    rs.getObject("flag"));
        }

        //�