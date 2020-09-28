package cn.itcast.demo02_preparestatemet预处理;

import cn.itcast.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    使用PreparedStatement执行增删改操作
 */
public class Demo03JDBC {
    public static void main(String[] args) throws SQLException {
        deleteMethod();
    }

    //执行删除
    //删除id是16的数据
    public static void deleteMethod() throws SQLException {
        //获取一个连接对象
        Connection con = JDBCUtils.getConnection();
        //对sql语句进行预编译
        String sql = "DELETE FROM product WHERE pid = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        //调用方法，设置问号占位符
        pst.setObject(1, 16);

        //调用方法执行sql
        int row = pst.executeUpdate();
        System.out.println(row);

        JDBCUtils.close(con, pst);
    }

    //执行修改
    //把id是16的商品改成火箭，价格888888，是上架
    public static void updateMethod() throws SQLException {
        //获取一个连接对象
        Connection con = JDBCUtils.getConnection();
        //对sql语句进行预编译
        String sql = "UPDATE product SET pname=?, price=?, flag=? WHERE pid=?";
        PreparedStatement pst = con.prepareStatement(sql);

        //调用setObject，替换问号占位符
        pst.setObject(1, "火箭");
        pst.setObject(2, 888888);
        pst.setObject(3, "1");
        pst.setObject(4, 16);

        //执行sql
        int row = pst.executeUpdate();
        System.out.println("row:" + row);

        JDBCUtils.close(con, pst);

    }

    //执行添加
    public static void insertMethod() throws SQLException {
        //获取一个连接对象
        Connection con = JDBCUtils.getConnection();
        //对sql语句进行预编译
        String sql = "INSERT INTO product (pname, price, flag) VALUES (?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);

        //替换里面的问号占位符
        pst.setObject(1, "红牛"); //使用红牛替换掉第一个问号占位符
        pst.setObject(2, 6);
        pst.setObject(3, "1");

        //执行sql
        int row = pst.executeUpdate();
        System.out.println("row:" + row);

        //释放资源
        JDBCUtils.close(con, pst);


    }
}
