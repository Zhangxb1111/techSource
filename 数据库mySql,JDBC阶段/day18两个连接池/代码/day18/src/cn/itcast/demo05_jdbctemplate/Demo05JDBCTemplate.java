package cn.itcast.demo05_jdbctemplate;

import cn.itcast.demo04_druid连接池.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
    query使用RowMapper做映射返回对象

    JDBCTemplate里面的query方法
    <T> List<T>	query(String sql, RowMapper<T> rowMapper, Object... args)：执行查询，并返回List集合. List集合中放的数据和rowMapper有关
        参数sql： sql语句
        参数rowMapper： 是一个接口，我们可以以匿名内部类的形式传递一个实现类。
        参数args： 用来替换问号占位符的实际参数

 */
public class Demo05JDBCTemplate {
    public static void main(String[] args) {
        //创建jdbcTemplate
        JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());
        //编写sql
        String sql = "SELECT * FROM product";
        List<Product> list = jdbcTemplate.query(sql, new RowMapper<Product>() {
            //参数rs表示每行结果集
            //参数i是第几次执行的mapRow，这个参数一般不用去管
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
                //创建Product
                Product p = new Product();
                //给这个Product的属性赋值
                p.setPid(rs.getInt("pid"));
                p.setPname(rs.getString("pname"));
                p.setPrice(rs.getInt("price"));
                p.setFlag(rs.getString("flag"));
                return p;//把p对象返回，最终会把这个对象放入到List集合
            }
        });

        //遍历这个集合
        for (Product p : list) {
            System.out.println(p);
        }
    }
}
