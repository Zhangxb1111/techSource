package cn.itcast.demo04_druid连接池;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
    提供一个方法getConnection，用来从Druid（德鲁伊）连接池中获取连接

    Druid是由第三方提供的，如果要使用需要导入jar包。

    准备工作：
        1. 导入jar包
        2. 编写.properties配置文件。
            这个配置文件建议放在src下，并且叫做druid.properties

    核心API
        DruidDataSourceFactory： 表示连接池工厂类。里面有一个方法，可以获取一个连接

    连接池工厂的方法：
        static DataSource	createDataSource(Properties properties)： 根据Properties中保存的四大信息创建一个连接池对象.

    使用步骤：
        1. 创建Properties并且将配置文件中的键值对读取到Properties中。
        2. 调用连接池工厂DruidDataSourceFactory的createDataSource方法，传递Properties对象，表示要根据这个Properties中的四大信息创建一个连接池
        3. 得到连接池之后调用连接池的getConnection获取连接

 */
public class DruidUtils {
    private static DataSource dataSource;

    //读取配置文件，以及创建连接池，做一次就可以了，可以让这些操作在类加载的时候执行
    static {
        try {
            //1. 创建Properties并且将配置文件中的键值对读取到Properties中。
            Properties p = new Properties();
            //src下的内容在类路径下也会有一个，获取类路径的东西
            InputStream in = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            p.load(in);

            //2. 调用连接池工厂的静态方法createDataSource获取一个连接池
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //用于从Druid连接池中获取连接
    public static Connection getConnection() throws Exception {
        //3. 调用连接池的getConnection获取连接
        Connection con = dataSource.getConnection();
        return con;
    }

    //提供一个方法，用于获取连接池对象.
    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void close(Connection con, Statement st) {
        close(con, st, null);
    }


    //释放资源
    public static void close(Connection con, Statement st, ResultSet rs) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
