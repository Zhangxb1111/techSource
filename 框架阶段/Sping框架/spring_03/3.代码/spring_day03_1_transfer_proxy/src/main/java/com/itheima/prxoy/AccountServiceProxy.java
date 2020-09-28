package com.itheima.prxoy;

import com.itheima.service.impl.AccountServiceImpl;
import com.itheima.utils.TxManager;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AccountServiceProxy {

    @Autowired
    TxManager txManager;

    /**
     * 获取代理对象的方法
     * @param object  被代理的对象
     * @return 代理对象
     */
    public AccountServiceImpl getProxyClass(final Object object){
        //增强类型
        Enhancer enhancer = new Enhancer();
        //设置代理对象的父类
        enhancer.setSuperclass(object.getClass());
        //方法的增强
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //开启事务
                txManager.openTransaction();
                //返回值的创建
                Object result = null;
                try {
                    //通过反射执行原来方法
                    result = method.invoke(object , objects);
                    txManager.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    txManager.rollback();
                } finally {
                    txManager.release();
                }
                return result;
            }
        });
        return (AccountServiceImpl) enhancer.create();
    }
}
