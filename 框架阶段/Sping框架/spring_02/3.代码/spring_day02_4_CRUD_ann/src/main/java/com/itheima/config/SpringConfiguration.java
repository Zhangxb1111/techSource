package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Configuration: spring核心配置配置文件
 * @ComponentScan : <context:component-scan base-package="com.itheima"></context:component-scan>
 * @Import:导入其他的配置文件
 **
 */

@Configuration
@ComponentScan({"com.itheima"})
@Import({JDBCConfiguration.class})
public class SpringConfiguration {
}
