package cn.itcast.demo05_jdbctemplate;
/*
    我们之前都是在使用jdbc操作数据库。 jdbc操作数据它的过程过于繁琐的。
    于是说就有了一些工具用来简化jdbc的操作，其中JDBCTemplate就是其中之一

    JDBCTemplate就是一个工具，里面封装了很多jdbc的操作，可以简化我们对数据库的开发。

    JDBCTemplate是第三方提供的，如果要用，需要导入jar包。

    核心类JDBCTemplate，可以执行sql语句。

    JDBCTemplate的构造方法
        JdbcTemplate(DataSource dataSource)： 参数要传递一个DataSource数据源，也就是连接池

    JDBCTemplate的其他方法
        void	execute(String sql)：一般拿这个方法执行 DDL语句

        int	update(String sql, Object... args)：执行增删改的方法(insert update delete)

        <T> T	queryForObject(String sql, Class<T> requiredType, Object... args)： 查询， 对于查询结果之后一个的语句，可以使用这个.
       <T> List<T>	query(String sql, RowMapper<T> rowMapper, Object... args)： 查询。


 */
public class Demo01JDBCTemplate {
}
 