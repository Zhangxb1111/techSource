package frame.utils;

import frame.domain.Configuration;
import frame.domain.Mapper;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * sql语句的执行器
 */
public class Executor {

    //配置文件的详细信息
    private Configuration cfg;

    public Executor(Configuration cfg) {
        this.cfg = cfg;
    }

    private Connection conn  = null;
    private Statement stm = null;
    private ResultSet rs = null;

    /**
     * 执行sql语句过程
     * @param mapper
     * @return
     */
    public List executeQuery(Mapper mapper){
        List list = new ArrayList();
        //获取sql语句
        String sql = mapper.getSql();
        try {
            //1.注册驱动
            Class.forName(cfg.getDriver());
            //2.获取连接
            conn = DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
            //3.创建 statement对象
            stm = conn.createStatement();
            // 4. 执行sql语句返回结果集
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 5. 处理结果集
        try {
            // 元数据：描述代码的代码
            // 结果集的元数据：-- 描述结果集的信息
            ResultSetMetaData metaData = rs.getMetaData();
            // 获取结果集中列的个数
            int columnCount = metaData.getColumnCount();
            // 声明一个集合：存储所有的列名
            List<String> columnNameList = new ArrayList<>();
            // 循环获取数据返回结果集的所有的列名:根据id获取，id从1 开始
            for (int i = 1; i <= columnCount ; i++) {
                String columnName = metaData.getColumnName(i);
                columnNameList.add(columnName);
            }
            while(rs.next()){  // 判断是否有下一条记录
                //获取返回值类型
                String resultType = mapper.getResultType();
                //获取返回值类型的字节码
                Class clazz = Class.forName(resultType);
                // 通过字节码创建对象
                Object obj = clazz.newInstance();
                // 给pojo对象赋值
                // 获取所有的方法
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    // 获取方法名
                    String methodName = method.getName();
                    // 循环所有的列名，目的是找到需要的set方法
                    for (String columnName : columnNameList) {
                        // 判断是否我们需要的set方法
                        if(methodName.equalsIgnoreCase("set"+columnName)){ // setusername
                            // 反射执行set方法,给pojo对象赋值
                                // p1: 执行的对象
                                //p2： 方法的参数
                            method.invoke(obj , rs .getObject(columnName) );
                        }
                    }
                }
                //对象赋值完成后添加到集合中
                list.add(obj);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("结果集封装失败！！！");
        }
        return list;
    }

    /**
     * 关闭资源
     */
    public void close() {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(stm!=null){
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
