package cn.itcast.demo03_c3p0连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/*
    工具类，里面提供一个方法，用于获取一个连接。
    之前工具类中的连接每次调用getConnection都会创建一个新的连接，这种方式非常消耗资源
    现在的做法，调用getConnection时，从连接池中获取连接。

    现在我们首先使用的连接池是C3P0连接池，这个连接池是由第三方提供的，如果要用，需要导入jar包。

    C3P0连接池中有一个核心类叫做ComboPooledDataSource， 这个类表示的就是连接池。

    使用步骤：
        1. 创建一个连接池（ComboPooledDataSource）对象
        2. 调用方法，设置数据库的四大信息（驱动类名， url， username， password）
            setDriverClass： 设置驱动类名
            setJdbcUrl: 设置url
            setUser()： 设置用户名
            setPassword()：设置密码
        3. 调用连接池的getConnection，从连接池中获取连接。


   把数据库的四大信息放到配置文件中，这样做更加灵活，可以提高程序的扩展性.

    1. 新建一个文件，叫做c3p0-config.xml（名字不能变）
    2. 把这个文件放到src（系统将来回读取类路径下的文件，放在src下，将来类路径下也会有一个这样的文件）
    3. 编写配置文件信息
    4. 注释掉之前我们手动设置四大信息的代码，因为此时我们使用了配置文件，系统自动会从配置文件中读取
 */
public class C3P0Utils {
    //创建连接池
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    /*
    static {
        try {
            //设置四大信息
            dataSource.setDriverClass("com.mysql.jdbc.Driver"); //驱动类名
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");//url
            dataSource.setUser("root");
            dataSource.setPassword("sorry");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
    */

    /*
        定义方法，用于获取连接，这个连接是从C3P0连接池中获取的
     */
    public static Connection getConnection() throws  SQLException {
        //调用连接池的getConnection，从连接池中获取连接。
        Connection con = dataSource.getConnection();
        return con;
    }
}
