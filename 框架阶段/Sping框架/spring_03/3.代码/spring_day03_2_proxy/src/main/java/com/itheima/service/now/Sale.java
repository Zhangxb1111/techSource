package com.itheima.service.now;

import com.itheima.domain.Product;

/**
 * 总代理
 */
public interface Sale {

    /**
     * 卖产品
     * @param money  如果价格合适，卖掉产品
     */
    public Product sale(Double money);
}
