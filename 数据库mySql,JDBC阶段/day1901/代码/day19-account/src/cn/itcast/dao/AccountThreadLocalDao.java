package cn.itcast.dao;

import cn.itcast.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
    转账案例的Dao层。
    这一层仅仅对数据库进行增删改查操作。
    Dao层会被Service层调用。


    提供两个方法：
        1. 入账
        2. 出账


    操作事务使用的连接一定要和执行sql语句用的连接对象是同一个，不然这个sql语句不属于之前开启的事务。
    可以通过参数的形式传递连接对象，保证使用的连接是同一个。
 */
public class AccountThreadLocalDao {
    /*
        入账方法，就是对指定的人加上指定的金额。

        如果方法内没有抛出异常，就表示入账成功，
        如果抛出了异常，就表示入账失败。
     */
    public void inMoney(String inName, int money)  {

        try {
            Connection con = ConnectionManager.getConnection();
            //对sql语句进行预编译
            PreparedStatement pst = con.prepareStatement("UPDATE account SET money=money+? WHERE name = ?");
            //设置参数
            pst.setObject(1, money);
            pst.setObject(2, inName);
            //执行sql
            pst.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("入账失败");
        }
    }

    /*
        出账方法
     */
    public void OutMoney(String outName, int money)  {

        try {
            Connection con = ConnectionManager.getConnection();
            //对sql语句进行预编译
            PreparedStatement pst = con.prepareStatement("UPDATE account SET money=money-? WHERE name = ?");
            //设置参数
            pst.setObject(1, money);
            pst.setObject(2, outName);
            //执行sql
            pst.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("出账失败");
        }
    }
}
