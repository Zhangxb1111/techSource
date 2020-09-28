package cn.itcast.demo03_jdbc工具测试类;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
    查询指定id的数据。

    查询id是 4的商品的数据
 */
public class Demo02JDBCTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //通过工具类直接获取到一个连接对象
        Connection con = JDBCUtils.getConnection();
        //通过连接获取sql语句执行者对象
        Statement st = con.createStatement();
        //调用executeQuery 方法执行查询
        String sql = "SELECT * FROM product WHERE pid = 4";
        ResultSet rs = st.executeQuery(sql);
        //rs表示结果集，里面封装了查询后的结果(表)
        //处理rs结果集
        if(rs.next()) {//因为根据主键id查询最多只有一条数据，所以可以使用if。
            System.out.println(rs.getObject("pid") + "\t" + rs.getObject("pname") + "\t" + rs.getObject("price") + rs.getObject("flag"));
        } else {
            System.out.println("没有查询到数据");
        }

        //释放资源
        JDBCUtils.close(rs, st, con);
    }
}
