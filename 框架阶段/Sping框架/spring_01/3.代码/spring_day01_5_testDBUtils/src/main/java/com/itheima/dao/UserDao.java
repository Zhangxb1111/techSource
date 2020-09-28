package com.itheima.dao;

import com.itheima.domain.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据中的字段必须与属性一致
 */
public class UserDao {
    QueryRunner queryRunner;

    public UserDao() {
        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mybatisdb_63");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        //执行sql语句的运行器
        queryRunner = new QueryRunner(dataSource);
    }

    public List<User> findAll(){
        //  p1: sql语句
        String sql = "select * from user";
        // p2 : 结果集的封装, 泛型：返回对象的类型， 构造方法参数：返回对象类型的字节码
        List<User> userList = null;
        //BeanListHandler ，返回集合时使用
        try {
            userList  = queryRunner.query(sql ,new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  userList;
    }

    public User  findById(Integer id){
        String sql = "select * from user where id = ?" ;
//        返回一个对象时使用BeanHandler
        User user = null;
        try {
            user = queryRunner.query(sql ,new BeanHandler<User>(User.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void update(User user){
        String sql = "update user set username=?,address=?,birthday=?,sex=? where id = ?";
        Object[] objects = new Object[]{user.getUsername(),user.getAddress(),user.getBirthday(),user.getSex() ,user.getId()};
        try {
            queryRunner.update(sql , objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(User user){
        String sql = "insert into user values(null , ?,?,?,?)";
        Object[] objects = new Object[]{user.getUsername(),user.getAddress(),user.getBirthday(),user.getSex()};
        try {
            queryRunner.update(sql , objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void del(Integer id){
        String sql = "delete from user where id = ?";
        try {
            queryRunner.update(sql , id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Long getTotalCount(){
        String sql = "select count(1) from user";
        Long totalCount = null;
        try {
            // 返回一个值时使用
            totalCount= (Long) queryRunner.query(sql , new ScalarHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalCount;
    }
}
