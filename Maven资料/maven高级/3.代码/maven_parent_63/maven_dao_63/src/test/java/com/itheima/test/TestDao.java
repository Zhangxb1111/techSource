package com.itheima.test;

import com.itheima.dao.SSMDao;
import com.itheima.domain.SSM;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-dao.xml")
public class TestDao {

    @Autowired
    SSMDao ssmDao;

    @Test
    public void test(){
        SSM ssm = ssmDao.findById(1);
        System.out.println(ssm.getText());

    }
}
