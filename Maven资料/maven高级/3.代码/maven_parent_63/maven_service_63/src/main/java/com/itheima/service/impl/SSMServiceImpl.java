package com.itheima.service.impl;

import com.itheima.dao.SSMDao;
import com.itheima.domain.SSM;
import com.itheima.service.SSMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ssm的业务层实现类
 */
@Service
public class SSMServiceImpl implements SSMService {
    @Autowired
    SSMDao ssmDao;

    @Override
    public SSM findById(Integer id) {
        return ssmDao.findById(id);
    }
}
