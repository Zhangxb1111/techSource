package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class AccountDaoImpl implements AccountDao {

    @Autowired
    QueryRunner queryRunner;


//    public AccountDaoImpl(){
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybatisdb_63");
//        try {
//            dataSource.setDriverClass("com.mysql.jdbc.Driver");
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//        dataSource.setUser("root");
//        dataSource.setPassword("root");
//        queryRunner = new QueryRunner(dataSource);
//    }

    public List<Account> findByPage(Integer pageSize, Integer pageNum) {
        //创建sql语句
        String sql = "select * from account limit ?,?";
        //执行sql语句
        Object[] objs =  new Object[]{(pageNum - 1) * pageSize , pageSize};
        List<Account> accountList = null;
        try {
            accountList = queryRunner.query(sql, new BeanListHandler<Account>(Account.class), objs);
        } catch (SQLException e) {
            throw  new RuntimeException();
        }
        //返回
        return accountList;
    }

    public Account findById(Integer id) {
        //创建sql语句
        String sql  = "select * from account where id = ?";
        //执行sql语句
        Account account = null;
        try {
            account = queryRunner.query(sql , new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        //返回
        return account;
    }

    public void save(Account account) {
        //创建sql语句
        String sql = "insert into account values(null ,?,?)";
        //执行sql语句
        try {
            queryRunner.update(sql ,account.getUsername(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public void update(Account account) {
        //创建sql语句
        String sql = "update account set username = ?, money = ? where id = ?";
        //执行sql语句
        try {
            queryRunner.update(sql ,account.getUsername(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public void delById(Integer id) {
        //创建sql语句
        String sql = "delete from account  where id = ?";
        //执行sql语句
        try {
            queryRunner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public int getTotalCount() {
        //创建sql语句
        String sql = "select count(1) from account";
        //执行sql语句
        Long count = 0L;
        try {
            count = (Long)queryRunner.query(sql ,new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回
        return count.intValue();
    }
}
