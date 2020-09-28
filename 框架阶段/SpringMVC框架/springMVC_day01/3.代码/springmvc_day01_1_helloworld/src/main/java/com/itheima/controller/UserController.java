package com.itheima.controller;

import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
/*
    spring 容器中
    key             value
    /print   ---    print()

 */


@Controller
@RequestMapping("/user") // 窄化路径
public class UserController {


    @RequestMapping("/testServletApi")
    public void testServletApi(HttpServletRequest request, HttpServletResponse response){

        System.out.println(request);
        System.out.println(request.getParameter("username"));
        System.out.println(response);
        try {
            response.sendRedirect("http://localhost:8080/springmvc_hello/aa.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 请求映射的路径
     * @return
     */
    @RequestMapping(value = "/print",method = RequestMethod.POST)
    public String  print(){
        System.out.println("打印了.............");
        // /WEB-INF/show.jsp
        return "show";
    }

    /**
     * params = {"name"} : 在请求中必须的有name参数
     * params = {"!name"} ：在请求中不能name参数
     * params = {"name","money>100"}：在请求中必须有name参数，money>100的的参数
     * params = {"！name","money>100"}：在请求中不能有name参数，money>100的的参数
     * @return
     */
    @RequestMapping(value = "/testParams", params = {"!name","money>100"})
    public String testParams(){
        System.out.println("保存用户");
        return "show";
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/saveUser",method = RequestMethod.POST)
    public String saveUser(Date birthday){
        System.out.println(birthday);
        return "show";
    }

    /**
     * @RequestParam("name")
         *  value： 当属性名与表单中的name不一致，做映射
         *  required :是否是必要属性， true，为必要属性，false，非必要属性
         *  defaultValue: 默认值，如果参数传递了，获取，如果没有传参，使用默认值
        *          分页时使用
     * @param username
     * @param age
     * @return
     */
    @RequestMapping(value = "/saveUser3",method = RequestMethod.POST)
    public String saveUser3(@RequestParam(value = "name",defaultValue = "rose") String username , Integer age){
        System.out.println("用户名："+username);
        System.out.println("年龄："+age);
        return "show";
    }

    /**
     * 使用pojo对象接收
     * @param user 用户对象
     * @return
     */
    @RequestMapping(value = "/saveUser2",method = RequestMethod.POST)
    public String saveUser2(User user ){
        System.out.println("姓名：" + user.getUsername());
        System.out.println("年龄：" + user.getAge());
        System.out.println("标记：" + user.getFlag());
        System.out.println("性别：" + user.getSex());
        System.out.println("角色名称：" + user.getRole().getRoleName());
        System.out.println("爱好：");
        for (String s : user.getPlay()) {
            System.out.print(s);
        }
        System.out.println();

        System.out.println("字符串的集合"+user.getStrList().size());
        System.out.println("字符串的集合中的第一个元素"+user.getStrList().get(0));
        System.out.println("role集合中的第一个元素"+user.getRoleList().get(0));
        System.out.println("role集合中的第二个元素"+user.getRoleList().get(1));
        System.out.println("rolemap集合中的第一个元素"+user.getRoleMap().get("one"));
        System.out.println("rolemap集合中的第二个元素"+user.getRoleMap().get("two"));
        return "show";
    }

    /**
     * 传递简单类型
     * @param username
     * @param age
     * @param flag
     * @param sex
     * @return
     */
    @RequestMapping(value = "/saveUser1",method = RequestMethod.POST)
    public String saveUser1(String username , Integer age,Boolean flag,Character sex){
        System.out.println("姓名：" + username);
        System.out.println("年龄：" + age);
        System.out.println("标记：" + flag);
        System.out.println("性别：" + sex);

        return "show";
    }


}
