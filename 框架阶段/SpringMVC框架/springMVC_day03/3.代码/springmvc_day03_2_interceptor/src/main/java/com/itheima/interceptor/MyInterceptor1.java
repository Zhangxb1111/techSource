package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {

    /**
     * 何时执行：
     *  只要配置了，在执行controller方法前执行
     * 有什么用
     *  对所有的请求会发生拦截，对拦截的方法进行业务判断
     *  如果符合要求，返回true
     *  不符合要求，返回false
     * 执行顺序
     *   按照配置拦截器的顺序执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截1：preHandler执行了");
        return true;
    }

    /**
     *  何时执行
     *      preHandle,返回true
     *      渲染页面之前执行（返回之前执行）
     *  有什么用
     *      判断返回的资源有没有问题
     *  执行顺序
     *      按照配置的倒序执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截1：postHandle执行了");
    }

    /**
     *  何时执行
     *      preHandle,返回true
     *      渲染页面完成后执行
     *  有什么用
     *      关闭资源
     *  执行顺序
     *      按照配置的倒序执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截1：afterCompletion执行了");
    }
}
