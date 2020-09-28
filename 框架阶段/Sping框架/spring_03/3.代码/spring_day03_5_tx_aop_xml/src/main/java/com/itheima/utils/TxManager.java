package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * transactionManager
 *
 * 事务管理类
 */
@Component
public class TxManager {

    @Autowired
    ConnectionUtil connectionUtil;

    /**
     * 打开事务
     */
    public void openTransaction(){
        try {
            connectionUtil.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtil.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try {
            connectionUtil.getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    public void release(){
        connectionUtil.release();
    }
}
