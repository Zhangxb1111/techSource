package cn.itcast.demo01_jdbc基本操作;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    使用jdbc执行修改操作

    把id是8的商品进行修改， 商品名修改成 土豆牛肉火腿盖浇饭 ，商品价格改成20，是否上架1
 */
public class Demo03JDBC {
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
        String sql = "UPDATE product SET pname='土豆牛肉火腿盖浇饭', price=10,flag='1' WHERE pid = 8";
        int row = st.executeUpdate(sql);
        System.out.println("row:" + row);

        //释放资源
        st.close();
        con.close();
    }
}
