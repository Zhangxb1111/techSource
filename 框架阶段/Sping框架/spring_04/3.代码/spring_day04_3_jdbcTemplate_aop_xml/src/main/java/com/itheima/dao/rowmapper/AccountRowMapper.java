package com.itheima.dao.rowmapper;

import com.itheima.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbcTemplate的结果映射
 */
public class AccountRowMapper implements RowMapper<Account> {
    /**
     * 数据库字段名与数据文件数据的映射
     * @param rs  jdbc的结果集
     * @param rowNum 行号，一般不用
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setUsername(rs.getString("username"));
        account.setMoney(rs.getDouble("money"));
        return account;
    }
}