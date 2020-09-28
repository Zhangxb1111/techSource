package com.itheima.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Value:给属性赋值:
 *          <property name="jdbcUrl" value="${jdbc.url}"></property>
 * @Bean("dataSource"):  通过方法创建的对象
 * @PropertySource("db.properties")： 引入属性文件
 *       <context:property-placeholder location="db.properties"></context:property-placeholder>
 *
 *  @PostConstruct : 相当于：bean中的属性init-method
 *  @PreDestroy :相当于：bean中的属性destroy-method
 *  @Scope：相当于：bean中的属性： scope
 */
@Configuration //可以省略
@PropertySource("db.properties")
public class JDBCConfiguration {


    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.driver}")
    private String driverClass;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        try {
            dataSource.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean("queryRunner")
    public QueryRunner createQueryRunner(){
        QueryRunner queryRunner = new QueryRunner(createDataSource());
        return queryRunner;
    }
}
