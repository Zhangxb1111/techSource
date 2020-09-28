package cn.itcast.demo05_jdbctemplate;

import cn.itcast.demo04_druid连接池.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/*
    jdbcTemplate的 queryForObject 的查询方法
    <T> T	queryForObject(String sql, Class<T> requiredType, Object... args)：执行查询，返回一个执行类型的数据。
            参数sql： 要执行的sql
            参数requiredType： 是一个类的Class对象，传递的是哪个类的Class，得到的就是什么类型的结果。
            参数args： 用于替换问号占位符的实际参数。
    使用步骤：
        1. 创建jdbcTemplate对象
        2. 调用queryForObject执行查询

    查询商品表中id是10的商品的商品名

 */
public class Demo04JDBCTemplate {
    public static void main(String[] args) {
        //创建jdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        //调用queryForObject执行查询
        String sql = "SELECT pname FROM product WHERE pid = ?";
        //String.class表示要得到的结果是String类型。  10表示要使用这个数据替换掉?占位符
        String result = jdbcTemplate.queryForObject(sql, String.class, 10);

        System.out.println(result);
    }
}
