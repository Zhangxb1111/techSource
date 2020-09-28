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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserOperateAction extends HttpServlet {


    // 创建service对象
    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
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

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取页面数据
        String username = request.getParameter("username");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        // 封装数据
        UserInfo userInfo = new UserInfo();
        if(null != username && !"".equals(username.trim())){
            userInfo.setUsername(username);
        }else{
            printErrorMsg("姓名不能为空!",response);
            return;
        }
        if(null != birthday && !"".equals(birthday.trim())){
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                userInfo.setBirthday(df.parse(birthday));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else{
            printErrorMsg("生日不能为空!",response);
            return;
        }
        if(null != sex && !"".equals(sex.trim())) {
            if (Integer.parseInt(sex) == 0) {
                userInfo.setSex("女");
            } else {
                userInfo.setSex("男");
            }
        }else{
            printErrorMsg("性别不能不空!",response);
            return;
        }
        if(null != address && !"".equals(address.trim())){
            userInfo.setAddress(address);
        }else{
            printErrorMsg("地址不能为空!",response);
            return;
        }
        // 执行操作
        int count = userService.operateUser(userInfo,UserService.OPERATE_INSERT);
        if(count > 0){
            // 成功
            response.sendRedirect("UserViewAction?method=findUserByPage&pageIndex=1");
        }else{
            printErrorMsg("添加失败",response);
        }
    }


    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取页面数据
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        // 封装数据
        if(null != id && !"".equals(id.trim())){
            UserInfo userInfo = userService.findUserByID(Integer.parseInt(id));
            if(null != username && !"".equals(username.trim())){
                userInfo.setUsername(username);
            }else{
                printErrorMsg("姓名不能为空!",response);
                return;
            }
            if(null != birthday && !"".equals(birthday.trim())){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    userInfo.setBirthday(df.parse(birthday));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else{
                printErrorMsg("生日不能为空!",response);
                return;
            }
            if(null != sex && !"".equals(sex.trim())) {
                if (Integer.parseInt(sex) == 0) {
                    userInfo.setSex("女");
                } else {
                    userInfo.setSex("男");
                }
            }else{
                printErrorMsg("性别不能不空!",response);
                return;
            }
            if(null != address && !"".equals(address.trim())){
                userInfo.setAddress(address);
            }else{
                printErrorMsg("地址不能为空!",response);
                return;
            }
            // 执行操作
            int count = userService.operateUser(userInfo,UserService.OPERATE_UPDATE);
            if(count > 0){
                // 成功
                response.sendRedirect("UserViewAction?method=findUserByPage&pageIndex=1");
            }else{
                printErrorMsg("更新失败",response);
            }
        }else{
            printErrorMsg("不能更新此人",response);
        }


    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收页面参数
        String id = request.getParameter("id");
        // 判断
        if(null != id && !"".equals(id.trim())){
            // 查询
            UserInfo userInfo = userService.findUserByID(Integer.parseInt(id));
            if(null != userInfo){
                int count = userService.operateUser(userInfo,UserService.OPERATE_DELETE);
                if(count > 0){
                    response.sendRedirect("UserViewAction?method=findUserByPage&pageIndex=1");
                }else{
                    printErrorMsg("删除失败!",response);
                }
            }else{
                printErrorMsg("没有这条数据",response);
            }
        }else{
            printErrorMsg("不能删除该信息",response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设定方法的返回值
        request.setCharacterEncoding("UTF-8");
        // 获取页面数据
        String method = request.getParameter("method");
        switch (method){
            case "add" :
                // 执行分页方法
                this.add(request,response);
                break;
            case "delete":
                // 执行删除
                this.delete(request,response);
                break;
            case "update":
                // 执行删除
                this.update(request,response);
                break;
            default:
                printErrorMsg("没有找到要执行的方法!",response);
                break;
        }
    }
}
