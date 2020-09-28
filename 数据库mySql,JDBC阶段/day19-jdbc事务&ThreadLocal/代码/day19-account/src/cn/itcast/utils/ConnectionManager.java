package cn.itcast.utils;

import java.sql.Connection;

/*
    连接管理工具类。

    里面的方法：
        1. 获取连接
            这个获取连接的方法，使用相同线程，得到的是同一个连接。（从当前线程上面获取连接）
        2. 开启事务
        3. 提交事务
        4. 回滚事务
 */
public class ConnectionManager {
    //在成员位置定义ThreadLocal对象。 用来为每个线程对象存放连接
    private static ThreadLocal<Connection> local = new ThreadLocal<>();
    /*
        获取连接。
        这个获取连接的方式是从当前线程上面获取
     */
    public static Connection getConnection() throws Exception {
        Connection con = local.get();
        //如果没有获取到连接，说明当前线程是第一次调用方法获取连接。之前并没有在当前线程上绑定过
        //那么我们就从连接池中获取一个新的连接，然后绑定到当前线程上
        if (con == null) {
            //从连接池中获取一个连接
            con = DruidUtils.getConnection();
            //把这个连接绑定到当前线程上
            local.set(con);
        }
        //返回
        return con;
    }

    /*
        定义方法，用来开启事务
     */
    public static void startTransaction() throws Exception {
        //从当前线程上面获取连接，并且开启事务
        getConnection().setAutoCommit(false);
    }

    /*
        定义方法，用来提交事务
     */
    public static void commitTransaction() throws Exception {
        getConnection().commit();
    }

    /*
        定义方法，用来回滚事务
     */
    public static void rollbackTransaction() throws Exception {
        getConnection().rollback();
    }
}
