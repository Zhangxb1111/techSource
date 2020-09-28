package cn.itheima.tnb.pojo;

/**
 * 映射文件实体类
 */
public class MapperInfo {


    // 属性
    private String sql;         // 获取XML中的SQL语句
    private String className;   // 获取XML中的返回类型


    // 对外方法

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
