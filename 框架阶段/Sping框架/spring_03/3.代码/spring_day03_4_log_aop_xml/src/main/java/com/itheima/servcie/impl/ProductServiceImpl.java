package com.itheima.servcie.impl;

import com.itheima.servcie.ProdectService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProdectService {
    public void save(String s) {
        System.out.println("执行了save方法"+s);
        try {
            int i = 1/1;
        }catch (Exception e){
            throw  new RuntimeException();
        }
    }

    public void update(String s) {
        System.out.println("执行了update方法"+s);
    }
}
