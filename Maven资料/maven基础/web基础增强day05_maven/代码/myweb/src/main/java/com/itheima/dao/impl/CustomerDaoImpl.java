package com.itheima.dao.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.utils.DataSourceUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoImpl implements CustomerDao{
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(DataSourceUtil.getDataSource());
  /*
     private Long custId;
    private String custName;
    private String custSource;
    private String custLevel;
    private String custIndustry;

    private String custPhone;
   */
    @Override
    public void save(Customer customer) {

        String sql = "insert into cst_customer values(null,?,?,?,?,?)";

        Object[] params = {customer.getCustName(),customer.getCustSource(),customer.getCustIndustry(),customer.getCustLevel(),customer.getCustPhone()};
        jdbcTemplate.update(sql,params);
    }
}
