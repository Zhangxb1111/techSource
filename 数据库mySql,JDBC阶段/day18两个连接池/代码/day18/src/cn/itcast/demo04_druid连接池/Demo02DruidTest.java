package cn.itcast.demo04_druid连接池;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
    使用连接池的方式获取连接，并且向product表中添加数据
 */
public class Demo02DruidTest {
    public static void main(String[] args) throws Exception {
        //获取一个连接对象
        Connection con = DruidUtils.getConnection();

        //对sql语句进行预编译
        String sql = "INSERT INTO product (pname,price,flag) VALUES (?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);

        //调用setObject设置参数
        pst.setObject(1, "直升机");
        pst.setObject(2, 888888);
        pst.setObject(3, "1");

        //执行sql
        int row = pst.executeUpdate();
        System.out.println(row);

        //释放资源
        DruidUtils.close(con, pst);

    }
}
