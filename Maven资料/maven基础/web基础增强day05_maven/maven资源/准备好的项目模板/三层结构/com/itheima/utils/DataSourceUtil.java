package com.itheima.utils;
import com.alibaba.druid.pool.DruidDataSource;

import java.util.ResourceBundle;

public class DataSourceUtil {
	private static DruidDataSource dataSource = new DruidDataSource();

	static{
		//读取src/druid-config.properties
		ResourceBundle bundle = ResourceBundle.getBundle("druid-config");
		String driver = bundle.getString("driver");
		String url = bundle.getString("url");
		String username = bundle.getString("username");
		String password = bundle.getString("password");

		//为DruidDataSource设置值
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
	}

	/**
	 * 返回DataSource
	 */
	public static DruidDataSource getDataSource() {
		return dataSource;
	}
}
