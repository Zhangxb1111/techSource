package cn.itheima.tnb.factory;

import cn.itheima.tnb.core.SqlSession;
import cn.itheima.tnb.core.impl.SqlSessionImpl;
import cn.itheima.tnb.pojo.MapperInfo;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class SqlSessionFactory {

    // 定义读取到的XML对象
    private InputStream config;

    public void setConfig(InputStream config) {
        this.config = config;
    }

    /**
     * 打开一个连接
     * @return
     */
    public SqlSession openSession(){
        SqlSessionImpl sqlSession = new SqlSessionImpl();
        sqlSession = readXMLConfig(sqlSession);
        return sqlSession;
    }
    // 解析XML
    public SqlSessionImpl readXMLConfig(SqlSessionImpl sqlSession){

        try {
            // 读取xml
            Document document = new SAXReader().read(config);
            // 获取根目录
            Element root = document.getRootElement();
            // 获取根目录下的property标签
            List<Element> plist = root.selectNodes("//property");
            // 循环获取里面的name和value
            for (Element element : plist) {
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                switch (name){
                    case "driver":
                        sqlSession.setDriver(value);
                        break;
                    case "url":
                        sqlSession.setUrl(value);
                        break;
                    case "username":
                        sqlSession.setUsername(value);
                        break;
                    case "password":
                        sqlSession.setPassword(value);
                        break;
                }
            }
            // 开始解析mapper标签
            List<Element> mlist = root.selectNodes("//mapper");
            // 开始解析拼接
            for (Element element : mlist) {
                // 获取每个mapper标签的resource属性
                String resource = element.attributeValue("resource");
                // 解析里面的标签内容
                readMapperXML(resource);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }

    public void readMapperXML(String resource){
        // 获取XML资源位置
        InputStream mapperxml = this.getClass().getClassLoader().getResourceAsStream(resource);

        try {
            // 解析
            Document document = new SAXReader().read(mapperxml);
            // 获取根标签
            Element root = document.getRootElement();
            // 获取根标签上的namespace属性值
            String namespace = root.attributeValue("namespace");
            // 开始解析select标签的id和resultType还有sql
            List<Element> slist = root.selectNodes("//select");
            // 循环
            for (Element element : slist) {
                String id = element.attributeValue("id");
                String resultType = element.attributeValue("resultType");
                String sql = element.getText(); // 获取标签之间的值
                MapperInfo mapperInfo = new MapperInfo();
                mapperInfo.setClassName(resultType);
                mapperInfo.setSql(sql);
                // 保存解析结果
                SqlSessionImpl.mappers.put(namespace+"."+id,mapperInfo);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
