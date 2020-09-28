package com.itheima.web;

import com.itheima.entity.UserInfo;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserViewAction extends HttpServlet {


    // 创建service对象
    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    public void findUserByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        String pi = request.getParameter("pageIndex");
        // 设定返回数据
        int pageIndex = 1;
        int pageSize = 10;
        int totalCount = 0;
        int totalPage = 0;
        List<UserInfo> pageList = null;
        // pageIndex的第一次边界值判断
        // 转换
        if(null != pi && !"".equals(pi.trim())){
            pageIndex = Integer.parseInt(pi);
        }
        // 边界值判定
        if(pageIndex < 1){
            pageIndex = 1;
        }
        // 获取总页数
        totalCount = userService.findUserByPageCount();
        if(totalCount > 0){
            // 计算总页数
            totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
            // 第二次计算页码的边界值
            if(pageIndex > totalPage){
                pageIndex = totalPage;
            }
            // 获取数据集合
            pageList = userService.findUserByPage(pageIndex,pageSize);
            // 保存数据
            request.setAttribute("pageIndex",pageIndex);
            request.setAttribute("pageSize",pageSize);
            request.setAttribute("totalPage",totalPage);
            request.setAttribute("totalCount",totalCount);
            request.setAttribute("list",pageList);
            // 转发
            request.getRequestDispatcher("user_list.jsp").forward(request, response);
        }else {
            this.printErrorMsg("暂无数据",response);
        }





    }

    public void findUserByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取页面参数
        String id = request.getParameter("id");
        // 判断
        if(null != id && !"".equals(id.trim())){
            // 获取数据
            UserInfo userInfo = userService.findUserByID(Integer.parseInt(id));
            if(null != userInfo){
                request.setAttribute("user",userInfo);
                // 转发
                request.getRequestDispatcher("user_update.jsp").forward(request,response);
            }else{
                printErrorMsg("没有这个人",response);
            }
        }else{
            this.printErrorMsg("没有查询到这个人",response);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设定方法的返回值
        request.setCharacterEncoding("UTF-8");
        // 获取页面数据
        String method = request.getParameter("method");
        switch (method){
            case "findUserByPage" :
                // 执行分页方法
                this.findUserByPage(request,response);
                break;
            case "findUserByID":
                // 按ID查询
                this.findUserByID(request,response);
                break;
            default:
                printErrorMsg("没有找到要执行的方法!",response);
                break;
        }
    }

    public void printErrorMsg(String msg, HttpServletResponse response) throws ServletException, IOException {
        msg = "<script type=\"text/javascript\">alert("+msg+");window.history.go(-1);</script>";
        // 设定响应流编码
        response.setCharacterEncoding("UTF-8");
        // 设定页面输出类型
        response.setContentType("text/html;chatset=UTF-8");
        // 获取响应流
        PrintWriter out = response.getWriter();
        // 向页面发送
        out.print(msg);
        // 关闭
        out.flush();
        out.close();

    }
}
