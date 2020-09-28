package com.itheima.service.now.proxy;

import com.itheima.domain.Product;
import com.itheima.factory.ProductFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 销售总代理商
 */
public class SaleProxy {

    /**
     * 动态代理： 随用随创建， 在原先的基础上进一步的增强
     * jdk动态代理： 基于接口，不修改源码 ，
     * 生成代理商
     *
     *  代理对象就是接口的一个实现类,动态实现的实现类
     * @param clz   创建代理对象的接口
     * @return
     */
    public static Object getProxy(Class clz){
        /*
            p1: 类加载器
            p2：实现的接口的数组， 如果没有实现接口，就不能代理
                clz.getInterfaces() :获取字节码类实现的所有的接口
            p3：增强的内容
                实现InvocationHandler接口的实现类
         */
       Object obj =  Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, new InvocationHandler() {
            /**
             *  此方法 就是代理方法的增强
             * @param proxy   代理的对象 ，一般不用
             * @param method   正在执行的方法，代理的方法
             * @param args      代理方法的参数
             * @return         代理方法的返回值
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("正在以"+args[0]+ "卖产品");
                //生成一个产品
                Product product = ProductFactory.create();
                //如果产品的价格高于了 卖的价格 赔钱了 不卖
                if(product.getMoney() > (Double) args[0] ){
                    System.out.println("赔了，不卖");
                }else{
                    System.out.println("赚了"+((Double) args[0]-product.getMoney())+"元，卖掉产品");
                    return product;
                }
                return null;
            }
        });

        return obj;
    }
}
