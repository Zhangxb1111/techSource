package com.itheima;

import com.itheima.config.SpringConfiguration;
import com.itheima.servcie.ProdectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class TestAop {

    @Autowired
    ProdectService prodectService;

    @Test
    public void test(){
        prodectService.save("aop");
    }
}
