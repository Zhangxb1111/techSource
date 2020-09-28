package cn.itheima.tnb.factory;

import java.io.InputStream;

/**
 * 构建者模式创建SqlSessionFactory
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory buider(){
        // 默认
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        InputStream config = this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory.setConfig(config);
        return  sqlSessionFactory;
    }

    public SqlSessionFactory buider(String filename){
        // 读取可以自定义命名
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        InputStream config = this.getClass().getClassLoader().getResourceAsStream(filename);
        sqlSessionFactory.setConfig(config);
        return  sqlSessionFactory;
    }

    public SqlSessionFactory buider(InputStream config){
        // 读取不同位置不同命的xml
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        sqlSessionFactory.setConfig(config);
        return sqlSessionFactory;
    }



}
