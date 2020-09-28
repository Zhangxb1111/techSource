package cn.itheima.tnb.core.impl;

import cn.itheima.tnb.core.SqlSession;
import cn.itheima.tnb.pojo.MapperInfo;
import cn.itheima.tnb.util.TnbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlSessionImpl implements SqlSession {

    private String driver;
    private String url;
    private String username;
    private String password;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Connection conn;

    // 保存mapper文件中select标签的映射结果
    public static Map<String,MapperInfo> mappers = new HashMap<String,MapperInfo>();


    public <T> List<T> selectList(String id) throws Exception {
        // 创建方法的返回值
        List<T> list = null;
        // 加载驱动
        Class.forName(driver);
        // 获取连接
        conn = DriverManager.getConnection(url,username,password);
        MapperInfo mapperInfo = mappers.get(id);
        if(null != mapperInfo){
            // 执行SQL语句
            PreparedStatement ps = conn.prepareStatement(mapperInfo.getSql());
            // 没有占位符直接执行
            ResultSet set = ps.executeQuery();
            list = TnbUtil.getListByResultSet(set,mapperInfo.getClassName());
        }
        // 获取结果
        return list;
    }
}
