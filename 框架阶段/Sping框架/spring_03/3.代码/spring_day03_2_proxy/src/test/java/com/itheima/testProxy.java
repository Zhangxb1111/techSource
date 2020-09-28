package com.itheima;

import com.itheima.service.now.Sale;
import com.itheima.service.now.proxy.SaleProxy;
import com.itheima.service.old.SaleImpl;
import com.itheima.service.old.proxy.OldSaleProxy;
import org.junit.Test;

/**
 * 动态代理： 随用随创建
 * jdk动态代理： 基于接口，不修改源码
 */
public class testProxy {

    @Test
    public void testJdkProxy(){
        Sale proxy = (Sale) SaleProxy.getProxy(Sale.class);
        proxy.sale(500.);
    }


    @Test
    public void testCglibProxy(){

        SaleImpl sale = new SaleImpl();

        SaleImpl proxy = (SaleImpl) OldSaleProxy.getProxy(sale);
        proxy.sale(54000.9);

    }
}
