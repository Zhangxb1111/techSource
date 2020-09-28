package frame.factory;

import java.io.InputStream;

/**
 * 采用的是构建者模式（创建型：创建对象：注重创建的细节）
 *
 * 构建SqlSessionFactory
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream){
        return  new SqlSessionFactory(inputStream);
    }

    public SqlSessionFactory build(String xmlPath){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return  new SqlSessionFactory(inputStream);
    }

    public SqlSessionFactory build(){
        String xmlPath = "SqlMapConfig.xml";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return  new SqlSessionFactory(inputStream);
    }
}
