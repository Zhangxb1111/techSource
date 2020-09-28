package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.rowmapper.AccountRowMapper;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 继承 JdbcDaoSupport 类 ， 必须在类中注入dataSource,只能在xml中配置
 *  之后可以从类中获取jdbcTemplate
 *
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {



    public List<Account> findAll() {
        //定义sql语句
        String sql = "select * from account";
        //执行sql语句
        List<Account> accountList = getJdbcTemplate().query(sql, new AccountRowMapper());
        getJdbcTemplate().query(sql ,new BeanPropertyRowMapper<Account>(Account.class));
        //返回结果
        return accountList;
    }

    public Account findByUsername(String username) {
        //定义sql语句
        String sql = "select * from account where username = ?";
//        //执行sql语句
        Account account = getJdbcTemplate().queryForObject(sql, new AccountRowMapper(), username);
//        List<Account> accountList = jdbcTemplate.query(sql, new AccountRowMapper());
//        //返回结果
//        if(accountList.size() > 1 || accountList.size() == 0){
//            throw new RuntimeException();
//        }
//        return accountList.get(0);
        return account;
    }

    public Account findById(Integer id) {
        //定义sql语句
        String sql = "select * from account where id = ?";
        //执行sql语句
        Account account = getJdbcTemplate().queryForObject(sql, new AccountRowMapper(), id);
        return account;
    }

    public void save(Account account) {
        //SQL定义
        String sql = "insert into account values(null,?,?)";
        //执行sql语句
//        jdbcTemplate.update(sql ,account.getUsername(),account.getMoney());
        //把所有的参数封装成了object数组
        Object[] objects = new Object[]{account.getUsername(),account.getMoney()};
        getJdbcTemplate().update(sql ,objects);
    }

    public void update(Account account) {
        String sql = "update account set username = ? ,money = ? where id = ?";
        //执行sql语句
        getJdbcTemplate().update(sql , account.getUsername(),account.getMoney(),account.getId());
    }

    public void delete(Integer id) {
//        String sql = "delete from account where id = ?";
//        jdbcTemplate.update(sql , id);
        String sql = "delete from account where id = "+ id;
        getJdbcTemplate().execute(sql);
    }

    public long getTotalCount() {
        String sql = "select count(1) from account";
        Long count = getJdbcTemplate().queryForObject(sql, Long.class);
        return count;
    }



}


