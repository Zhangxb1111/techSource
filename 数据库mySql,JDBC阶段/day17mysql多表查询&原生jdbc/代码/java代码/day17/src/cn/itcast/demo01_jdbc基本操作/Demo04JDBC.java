package cn.itcast.demo01_jdbc基本操作;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    jdbc执行删除

    删除 id是 8的商品
 */
public class Demo04JDBC {
    public static void main(String[] args) throws SQLException {
        //注册驱动
        DriverManager.registerDriver(new Driver());

        //获取连接
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "sorry";
        Connection con = DriverManager.getConnection(url, username, password);

        //获取sql语句执行者对象
        Statement st = con.createStatement();

        //执行sql
        String sql = "DELETE FROM product WHERE pid = 8";
        int row = st.executeUpdate(sql);
        System.out.println(row);

        //释放资源
        st.close();
        con.close();
    }
}
