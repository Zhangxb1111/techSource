package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor  implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 判断是否是登录操作，放行
        String requestURI = request.getRequestURI();
        if (requestURI.contains("login")){
            return true;
        }
        //2. 如果不是登录操作：拦截， 判断session中是否有登录信息，如果有，放行，如果没有，拦截，返回登录页面
        Object username = request.getSession().getAttribute("username");
        if(username == null) {
            System.out.println("请登录");
            //跳转到登录页面
            //获取服务器路径
            String servletPath = request.getContextPath();

            response.sendRedirect(servletPath+"/login.jsp");
        }
        //最终放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
