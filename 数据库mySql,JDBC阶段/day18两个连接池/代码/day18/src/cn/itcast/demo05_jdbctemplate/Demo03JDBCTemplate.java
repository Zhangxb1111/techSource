package cn.itcast.demo05_jdbctemplate;

import cn.itcast.demo04_druid连接池.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/*
    使用JDBCTemplate 执行对数据的增删改操作（insert update delete）

    执行增删改操作，需要使用update方法
    int	update(String sql, Object... args)：执行增删改的方法
            参数sql： 表示sql语句， 这个sql语句允许有?占位符
            参数args：是一个可变参数，表示用来替换问号占位符的实际参数

    使用步骤：
        1. 创建jdbcTemplate对象
        2. 调用update方法，执行sql

 */
public class Demo03JDBCTemplate {
    public static void main(String[] args) {
        //insertMethod();
        //updateMethod();
        deleteMethod();
    }

    //执行删除语句
    public static void deleteMethod() {
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        //执行sql
        String sql = "DELETE FROM category WHERE cid = ?";
        Object[] params = {3}; //用于替换问号占位符的实际参数

        jdbcTemplate.update(sql, params);
    }

    //执行修改语句
    public static void updateMethod() {
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        //编写sql
        String sql = "UPDATE category SET cname = ?, details = ? WHERE cid = ?";
        Object[] params = {"蔬菜", "新鲜的蔬菜", 3};
        jdbcTemplate.update(sql, params);//可变参数的位置也可以传递数组
    }

    public static void insertMethod() {
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        //编写sql
        String sql = "INSERT INTO category (cname, details) VALUES (?,?)";
        //调用update方法，执行sql
        jdbcTemplate.update(sql, "家用电器", "很智能的家电");
        jdbcTemplate.update(sql, "数码产品", "华强北直销");
        jdbcTemplate.update(sql, "水果", "新鲜的水果");
    }
}
