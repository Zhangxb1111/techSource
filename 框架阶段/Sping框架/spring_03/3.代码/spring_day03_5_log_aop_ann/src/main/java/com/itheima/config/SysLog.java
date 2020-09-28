package com.itheima.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志类
 *
 * 方法前，方法后， 方法异常
 *
 * 名词解释：joinPoint;连接点， 拦截方法的点， 包含了执行方法的信息
 *          通知对象： 拦截后要通知的对象
 */
@Component
@Aspect
public class SysLog {

    @Pointcut("execution(* com.itheima.servcie.impl.*.*(..))")
    public void pointcut(){}

//    @Before("pointcut()")
//    public void methodBefore(JoinPoint joinPoint){
//        //获取的类的全类名
//        String className = joinPoint.getTarget().getClass().getName();
//        System.out.println("代理的类是：" +className);
//        //获取方法名称
//        System.out.println("执行的方法：" + joinPoint.getSignature().getName());
//    }
//
//    @AfterReturning("pointcut()")
//    public void methodReturningAfter(JoinPoint joinPoint){
//        System.out.println("执行service方法后返回前执行, 后置增强，如果有异常，则不执行");
//    }
//    @After("pointcut()")
//    public void methodAfter(JoinPoint joinPoint){
//        System.out.println("执行service方法后执行，最终增强，有没有异常，都会显示");
//    }
//
//    @AfterThrowing("pointcut()")
//    public void throwing(JoinPoint joinPoint){
//        System.out.println("有异常会执行到");
//    }

    /**
     * 换绕增强: 常用的增强
     */
    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint){
        //执行代理的方法：反射中invoke
        try {
            System.out.println("前置增强");
            joinPoint.proceed();
            System.out.println("后置增强");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("异常处理");
        } finally {
            System.out.println("最终增强");
        }
    }

}
