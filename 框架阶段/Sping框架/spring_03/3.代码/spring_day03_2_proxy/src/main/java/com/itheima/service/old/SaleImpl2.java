package com.itheima.service.old;

import com.itheima.domain.Product;
import com.itheima.factory.ProductFactory;

/**
 * 网点
 */
public class SaleImpl2 {

    /**
     * 销售产品
     * @param money 以多少钱卖出去
     */
    public Product sal(Double money){
        System.out.println("以"+money+"卖出去");

        return ProductFactory.create();
    }
}
