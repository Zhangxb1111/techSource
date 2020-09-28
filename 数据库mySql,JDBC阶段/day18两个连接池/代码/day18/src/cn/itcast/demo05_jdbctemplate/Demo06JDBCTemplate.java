package cn.itcast.demo05_jdbctemplate;

import cn.itcast.demo04_druid连接池.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/*
    query使用BeanPropertyRowMapper做映射返回对象。

    在jdbcTemplate中，有一个类是RowMapper接口的实现类， 这个类是BeanPropertyRowMapper

    在query方法中，第二个参数是一个RowMapper接口类型
    <T> List<T>	query(String sql, RowMapper<T> rowMapper, Object... args)

    BeanPropertyRowMapper是RowMapper的实现类，所以我们可以传递BeanPropertyRowMapper对象


    总结查询：
        queryForObject： 对于查询结果只有一个的，可以使用这个方法。
        query： 如果查询结果有多个，可以使用这个方法。 这个方法可以将查询后的数据放入到一个List集合中。
 */
public class Demo06JDBCTemplate {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());

        //编写sql
        String sql = "SELECT * FROM product";
        //BeanPropertyRowMapper 参数需要传递一个类的Class对象
        //传递的是哪个类的Class将来得到结果集合中放的就是什么类型的对象。
        List<Product> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));

        for (Product p : list) {
            System.out.println(p);
        }

    }
}
