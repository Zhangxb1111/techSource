package cn.itcast.demo02_preparestatemet预处理;

import cn.itcast.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
    使用PreparedStatement查询id是3的数据
 */
public class Demo02JDBC {
    public static void main(String[] args) throws SQLException {
        //获取一个连接对象
        Connection con = JDBCUtils.getConnection();

        //获取PreparedStatement，并且对sql语句进行预编译
        //sql语句中动态会变化的部分使用?占位符代替
        String sql = "SELECT * FROM product WHERE pid = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        //调用方法，设置参数（替换问号占位符）
        pst.setObject(1, 3);//使用数字3替换掉sql语句中的第一个问号

        //调用方法，执行sql
        ResultSet rs = pst.executeQuery();
        //判断
        if (rs.next()) {
            System.out.println(rs.getObject("pid") + "\t" + rs.getObject("pname") + "\t" + rs.getObject("price") + "\t" + rs.getObject("flag"));
        } else {
            System.out.println("对不起没有查询到数据");
        }

        JDBCUtils.close(con, pst, rs);
    }
}
