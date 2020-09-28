package com.itheima.service.old.proxy;

import com.itheima.domain.Product;
import com.itheima.factory.ProductFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 动态代理
 *    基于类的动态代理
 *    第三方代理
 *    对原有的方法进行增强
 *    代理类对象都是被代理对象的子类，实现类
 */
public class OldSaleProxy {


    /**
     * 获取代理对象
     * @param object 被代理的对象
     */
    public  static Object getProxy(final Object object){
        //增强类
        Enhancer enhancer = new Enhancer();
        //设置增强类的父类
        enhancer.setSuperclass(object.getClass());
        //增强方法 , 拦截方法 ，  拦截后增强， 并执行原有的方法
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o     代理的对象
             * @param method 代理的方法
             * @param objects  代理方法的参数
             * @param methodProxy  方法的代理，一般没有用
             * @return      方法的最终返回值
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("正在以"+objects[0]+"价格卖产品！！！！");


                //工厂生产一个产品
                Product product = ProductFactory.create();
                if ( product.getMoney() > (Double) objects[0]){
                    System.out.println("赔钱，不卖！！");
                }else{
                    //通过的反射执行现有的方法
                    // p1: 执行代理对象
                    method.invoke(object,objects );
                    System.out.println("赚了"+( (Double) objects[0] - product.getMoney())+"元，卖了");
                    return  product;
                }
                return null;
            }
        });
        //创建增强对象
        return enhancer.create();
    }
}
