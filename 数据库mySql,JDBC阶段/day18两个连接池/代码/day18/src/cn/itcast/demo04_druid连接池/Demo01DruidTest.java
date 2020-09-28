package cn.itcast.demo04_druid连接池;

import java.sql.Connection;

public class Demo01DruidTest {
    public static void main(String[] args) throws Exception {
        Connection con = DruidUtils.getConnection();
        System.out.println(con);
    }
}
