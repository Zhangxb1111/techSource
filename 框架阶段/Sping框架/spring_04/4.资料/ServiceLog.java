package com.itheima.util;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class ServiceLog {


    @Pointcut("execution(* com.itheima.service..*.*(..))")
    public void pointCut(){

    }

    @Around(value="pointCut()")
    public Object aroundLog(ProceedingJoinPoint pjp){
        // 获取类型
        String className = pjp.getTarget().getClass().getName();
        // 获取方法
        String method = pjp.getSignature().getName();
        // 获取参数
        Object[] args = pjp.getArgs();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Object result = null;
        try {
            System.out.println("["+dateFormat.format(new Date())+"]准备执行"+method+"方法[参数"+ Arrays.toString(args)+",归属类"+className+"]");
            result = pjp.proceed();
            System.out.println("["+dateFormat.format(new Date())+"]已经执行"+method+"方法[返回值"+ result.toString()+",归属类"+className+"]");
        } catch (Throwable throwable) {
            System.out.println("["+dateFormat.format(new Date())+"]已经执行"+method+"方法[错误信息:"+ throwable.getMessage() +",归属类"+className+"]");
            throwable.printStackTrace();
        }finally {
            System.out.println("["+dateFormat.format(new Date())+"]开始销毁相应资源");
        }
        return result;

    }



}
