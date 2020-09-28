package cn.itcast.demo00_课堂测试;

import cn.itcast.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*

*/

public class Demo01Test {
    public static void main(String[] args) throws SQLException {
        //获取一个连接对象
        Connection con = JDBCUtils.getConnection();
        //对sql语句进行预编译
        String sql = "INSERT INTO product (pname, price, flag) VALUES (?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);

        //替换里面的问号占位符
        pst.setObject(1, "绿牛"); //使用红牛替换掉第一个问号占位符
        pst.setObject(2, 6);
        pst.setObject(3, "1");

        //执行sql
        int row = pst.executeUpdate();

        pst.setObject(1, "白牛");
        pst.setObject(2, 5);
        pst.setObject(3, "0");
        pst.executeUpdate();

        //释放资源
        JDBCUtils.close(con, pst);
    }
}
