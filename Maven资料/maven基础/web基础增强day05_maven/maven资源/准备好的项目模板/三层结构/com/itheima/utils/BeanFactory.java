package com.itheima.utils;

import java.util.ResourceBundle;

public class BeanFactory {

    /**
     * 给你接口 给我实现
     * @param interfaceClass
     * @param <T>
     * @return
     */
    public static <T>T newInstance(Class<T> interfaceClass){
        //获取接口的名字
        String simpleName = interfaceClass.getSimpleName();
        //解析properties文件 获取该接口对应的实现类
        String implClassName = ResourceBundle.getBundle("beans").getString(simpleName);
        //反射创建该对象
        try {
            Class aClass = Class.forName(implClassName);
            return (T) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
