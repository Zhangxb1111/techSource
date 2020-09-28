package com.itheima.factory;

import com.itheima.domain.Product;

public class ProductFactory {

    /**
     * 生成产品
     * @return
     */
    public static Product create(){
        Product product = new Product();
        product.setMoney(3000);
        return product;
    }

    /**
     * 卖产品
     * @param money
     */
    public void sale(Double money){
        System.out.println("产品的价格："+ money);
    }
}
