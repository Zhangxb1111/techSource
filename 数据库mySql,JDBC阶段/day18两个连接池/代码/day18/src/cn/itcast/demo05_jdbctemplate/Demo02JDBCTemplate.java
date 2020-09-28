package cn.itcast.demo05_jdbctemplate;

//使用jdbcTemplate执行DDL
//通过java程序向数据库中添加一张表。
//create table 表名(...);

import cn.itcast.demo04_druid连接池.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class Demo02JDBCTemplate {
    /*
        jdbcTemplate使用步骤
        1. 创建对象
        2. 调用方法执行sql语句

        执行DDL用的方法是execute
        void	execute(String sql)：一般拿这个方法执行 DDL语句
    */
    public static void main(String[] args) {
        //创建JDBCTemplate对象
        //参数需要传递一个连接池对象，那么以后使用这个jdbcTemplate操作的sql都是从这个连接池中获取的连接
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        //2. 调用方法执行sql语句
        String sql = "CREATE TABLE category(" +
                "cid INT PRIMARY KEY AUTO_INCREMENT," +
                "cname VARCHAR(20)," +
                "details VARCHAR(20)" +
                ")";
        jdbcTemplate.execute(sql);
    }
}
