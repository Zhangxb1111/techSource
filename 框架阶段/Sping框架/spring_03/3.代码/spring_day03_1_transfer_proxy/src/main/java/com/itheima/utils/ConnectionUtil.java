package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 线程: 当前线程的绑定： ThreadLocal
 */
@Component
public class ConnectionUtil {

    @Autowired
    private DataSource dataSource;

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public Connection getConnection(){
        //如果线程绑定了connection，通过get方法来获取
        Connection conn = tl.get();
        // 如果连接为null，需要获取连接
        if(conn == null){
            try {
                //第一个使用连接是，线程中没有连接，从连接池中获取
                conn =  dataSource.getConnection();
                //绑定连接对象到当前线程
                tl.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tl.get();
    }
    // 从当前线程中移除绑定的连接
    public void release(){

        tl.remove();
    }
}
