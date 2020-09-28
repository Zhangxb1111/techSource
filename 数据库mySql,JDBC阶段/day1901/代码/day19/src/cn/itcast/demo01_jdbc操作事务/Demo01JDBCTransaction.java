package cn.itcast.demo01_jdbc操作事务;

import cn.itcast.utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
    使用jdbc模拟转账操作

    在转账的过程中，要保证所有的操作是一组操作，这组操作要么都成功要么都失败。
    如果要把多个操作看成是同一组可以使用事务。

    步骤：
    1. 在转账之前开启事务
    2. 进行转账。
    3. 如果转账过程中没有问题，那么就提交事务
    4. 如果转账过程中遇到了问题，那么就回滚事物。

    jdbc操作事务需要使用Connection连接对象里面的方法进行操作。
        void setAutoCommit​(boolean autoCommit) ： 可以开启事务。 如果是false，表示设置了事务的手动提交，也就是相当于开始事务。
                                                                 如果是true，表示事务是自动提交，每执行一句，就生效一句。
        void commit​()： 提交事务。 让这个事务内的操作全部都生效
        void rollback​()： 回滚事物。 上这个事物内的操作全部失效。

 */
public class Demo01JDBCTransaction {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            //获取一个连接
            con = DruidUtils.getConnection();

            //使用连接对象开启事务
            con.setAutoCommit(false); //设置事务手动提交，也就是开启事务

            //获取一个sql语句执行者对象
            st = con.createStatement();
            //开始执行sql
            //给jack的钱减去100
            int row1 = st.executeUpdate("UPDATE account SET money=money-100 WHERE name='jack'");
            System.out.println("row1:" + row1);

            //停电了
            //System.out.println(10 / 0);

            //给rose的钱加上100
            int row2 = st.executeUpdate("UPDATE account SET money=money+100 WHERE name='rose'");
            System.out.println("row2:" + row2);

            //提交事务
            con.commit();
            System.out.println("转账成功");
        } catch (Exception e) {
            //如果转账过程出现异常，会被这个catch捕获到，那么就在这里面回滚事物
            try {
                if(con != null) {
                    con.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            System.out.println("转账失败");
        } finally {
            //释放资源
            DruidUtils.close(con, st);
        }
    }
}
