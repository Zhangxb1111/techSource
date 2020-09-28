package com.itheima.test;

import com.itheima.entity.UserInfo;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.Date;

/**
 * 测试类
 */
public class M2Test3 {

    @Test
    public void test(){
        UserInfo userInfo = null;
        UserService service = new UserServiceImpl();
        for (int i = 0; i < 300; i++) {
             userInfo = new UserInfo();
             userInfo.setUsername("测试数据");
             userInfo.setAddress("测试数据");
             userInfo.setBirthday(new Date());
             userInfo.setSex("无");
             int count = service.operateUser(userInfo,UserService.OPERATE_INSERT);
             if(count > 0){
                 System.out.println("OK");
             }else{
                 System.out.println("NO");
                 break;
             }
        }
    }
}
