package cn.itheima.tnb.util;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class TnbUtil {


    /**
     * list集合转换
     * @param set
     * @param className cn.itheima.entity.UserInfo
     * @param <T>
     * @return
     */
    public static <T> List<T> getListByResultSet(ResultSet set,String className){
        // 创建方法的返回值
        List<T> list = new ArrayList<T>();
        // set+列名
        // 第一步怎么获取表的列名
        // 元数据
        try {
            ResultSetMetaData md = set.getMetaData();
            // 获取列的个数
            int count = md.getColumnCount(); // 5
            // 列名集合
            List<String> cnames = new ArrayList<String>();
            for (int i = 1; i <= count; i++) {
                 cnames.add(md.getColumnName(i));
            }
            // set
            // 加载类结构
            Class clz = Class.forName(className);
            // 获取所有的方法
            Method[] methods = clz.getMethods();
            // 遍历resultset
            T object = null;
            while(set.next()){
                object = (T)clz.newInstance(); // 反射
                // 列名找set方法
                for (String cname : cnames) {
                    for (Method method : methods) {
                        // id setid = set+id
                        if(method.getName().equalsIgnoreCase("set" + cname)){
                            // 如果找到了直接执行
                            method.invoke(object,set.getObject(cname));
                            // id set方法 object set.getObject("id")
                        }
                    }
                }
                list.add(object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回
        return list;
    }



}
