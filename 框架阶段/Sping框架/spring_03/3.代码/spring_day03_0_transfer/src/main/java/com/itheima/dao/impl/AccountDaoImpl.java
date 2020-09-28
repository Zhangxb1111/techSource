package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao{

    @Autowired
    QueryRunner queryRunner;

    @Autowired
    ConnectionUtil connectionUtil;

    public List<Account> findAll() {
        //sql语句
        String  sql = "select * from account";
        //执行sql语句
        List<Account> accountList = null;
        try {
            accountList = queryRunner.query(connectionUtil.getConnection(),sql , new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public Account findByUsername(String username) {
        //sql语句
        String sql = "select * from account where username = ?";
        //执行sql语句
        Account account = null;
        try {
            account = queryRunner.query(connectionUtil.getConnection(),sql ,new BeanHandler<Account>(Account.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> findByPage(Integer pageNum, Integer pageSize) {
        return null;
    }

    public Account findById(Integer id) {
        return null;
    }

    public void save(Account account) {

    }

    public void update(Account account) {
        String sql = "update account set  username = ? ,money = ? where id = ?";
        try {
            queryRunner.update(connectionUtil.getConnection(),sql ,account.getUsername(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void del(Integer id) {

    }

    public int getTotalCount() {
        return 0;
    }
}
