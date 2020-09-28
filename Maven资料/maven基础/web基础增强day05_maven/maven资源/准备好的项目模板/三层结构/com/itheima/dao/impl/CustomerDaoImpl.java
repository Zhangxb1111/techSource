package com.itheima.dao.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.utils.DataSourceUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoImpl implements CustomerDao{
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(DataSourceUtil.getDataSource());

}
