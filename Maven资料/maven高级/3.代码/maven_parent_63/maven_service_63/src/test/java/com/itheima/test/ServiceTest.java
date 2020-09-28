package com.itheima.test;

import com.itheima.domain.SSM;
import com.itheima.service.SSMService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//classpath:只能读取本项目的配置文件
//classpath*: 可以读取本项目和依赖项目的配置文件
@ContextConfiguration("classpath*:spring/applicationContext-*.xml")
public class ServiceTest {


    @Autowired
    SSMService ssmService;

    @Test
    public void test(){
        SSM ssm = ssmService.findById(2);
        System.out.println(ssm.getText());
    }
}
