package cn.itcast.demo01_jdbc基本操作;

import com.mysql.jdbc.Driver;

import java.sql.*;

/*
    jdbc执行查询操作
    1. 注册驱动
    2. 获取连接
    3. 获取sql语句执行者对象
    4. 执行sql
    5. 处理结果。
    6. 释放资源
 */
public class Demo05JDBC {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1. 注册驱动
        //DriverManager.registerDriver(new Driver());  这种方式会注册两次

        Class.forName("com.mysql.jdbc.Driver"); //反射的方式注册驱动，只会注册一次

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/mydb";
        String username = "root";
        String password = "sorry";
        Connection con = DriverManager.getConnection(url, username, password);

        //3. 获取Sql语句的执行者对象。
        Statement st = con.createStatement();

        //4. 执行sql
        //注意执行查询不不能再使用executeUpdate了
        //要使用executeQuery，这个方法会执行查询，并且返回查询后的结果
        //ResultSet executeQuery​(String sql) 执行查询，返回值ResultSet。表示结果集，里面封装了查询后的结果
        String sql = "SELECT * FROM product";
        /*
            返回值ResultSet对象中封装了查询之后的结果(表)。
            ResultSet里面封装了查询后的表，里面还有一个光标，这个光标指向第一行之前。
            ResultSet处理结果集需要用到两个方法
            boolean next​()： 把光标向下移动一行，并判断这行有没有数据。
            getXXX(列名): 获取当前行指定列上的数据
         */
        ResultSet rs = st.executeQuery(sql);

        //a. 把光标向下移动一行，判断这一行有没有数据
        //b. 如果有数据，就获取
        //a 和 b要重复执行， 所以要放入到循环中
        while (rs.next()) { //一直让光标向下移动，每移动一行，就判断这一行有没有数据。
            //如果条件成立表示当前这一行是有数据的，那么我们就获取
            //调用getXXX进行获取
            //int pid = rs.getInt("pid");
            //String pname = rs.getString("pname");
            //int price = rs.getInt("price");
            //String flag = rs.getString("flag");
            //\t是一个制表符，表示一个tab键
            //System.out.println(pid + "\t" + pname + "\t" + price + "\t" + flag);

            //偷懒的做法
            System.out.println(rs.getObject("pid") + "\t" + rs.getObject("pname") + "\t" + rs.getObject("price") + "\t" + rs.getObject("flag"));
        }

        //释放资源
        rs.close();
        st.close();
        con.close();

    }
}
