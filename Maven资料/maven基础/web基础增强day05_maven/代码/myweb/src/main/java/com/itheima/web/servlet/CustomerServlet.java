package com.itheima.web.servlet;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.itheima.utils.BeanFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/add")
public class CustomerServlet extends HttpServlet {


    private CustomerService customerService= BeanFactory.newInstance(CustomerService.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 接收参数
        Map<String, String[]> parameterMap = request.getParameterMap();

        //通过BeanUtils封装对象
        Customer customer = new Customer();

        try {
            BeanUtils.populate(customer,parameterMap);
        }  catch (Exception e) {
            e.printStackTrace();
        }

        // 需要service 完成

        customerService.save(customer);

        // 添加完成了

        // 跳转成功页面
        request.getRequestDispatcher("/success.jsp").forward(request,response);


    }
}
