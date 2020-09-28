package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.service.CustomerService;
import com.itheima.utils.BeanFactory;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao= BeanFactory.newInstance(CustomerDao.class);
}
