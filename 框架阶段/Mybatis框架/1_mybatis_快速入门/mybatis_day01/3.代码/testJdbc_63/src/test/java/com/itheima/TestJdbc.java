package com.itheima;

import com.itheima.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * pojo : 简单的java对象， 就是用来封装数据的
 *  声明了一些属性，给属性提供了set和get方法
 *
 *
 *  优点： 效率高
 *  缺点： 1，对数据库的连接对象频繁的创建和销毁
 *         2， sql语句在java代码中硬编码
 *         3. 在传参数硬编码
 *         4. 处理结果集硬编码
 *
 *  mybatis 就能解决一部分问题
 */
public class TestJdbc {

    public static void main(String[] args) {
        Connection conn = null;
        Statement stm= null;
        ResultSet rs= null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接对象Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatisdb_63" ,"root", "root");
            //3. 创建statement对象
            stm = conn.createStatement();
            //4. 定义sql语句
            String  sql = "select * from user where username = ? and address= ?";
            //5. 执行sql语句,返回结果街
            rs = stm.executeQuery(sql);
            //6. 处理结果集，封装成pojo对象
            List<User> list = new ArrayList<>();
            while(rs.next()){ //判断结果集中是否有下一条数据
                //每条记录对应一个user对象
                User user = new User();
                //给user赋值
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setBirthday(rs.getString("birthday"));
                user.setAddress(rs.getString("address"));
                user.setSex(rs.getString("sex"));
                // 把user对象添加到集合中
                list.add(user);
            }


            //看一下结果
            for (User user : list) {
                System.out.println(user.getId());
                System.out.println(user.getUsername());
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源： 先打开的后关闭
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(stm!=null){
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
