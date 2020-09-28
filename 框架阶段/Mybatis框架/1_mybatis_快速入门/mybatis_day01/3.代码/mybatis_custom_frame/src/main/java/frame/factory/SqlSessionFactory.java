package frame.factory;

import frame.dao.SqlSession;
import frame.dao.impl.SqlSessionImpl;
import frame.domain.Configuration;
import frame.domain.Mapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 采用的工厂模式创建对象（只注重创建一个对象）
 *
 * 创建sqlSesision对象
 *
 * 加载配置文件
 */
public class SqlSessionFactory {

    InputStream inputStream;

    /**
     * 核心配置文件的输入流对象
     * @param inputStream
     */
    public SqlSessionFactory(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    Configuration cfg;

    /**
     * 创建sqlSessionImpl对象
     * @return
     */
    public SqlSession openSession(){
        cfg = new Configuration();
        //在创建sqlsession之前加载配置文件
        loadConfiguration();
        return new SqlSessionImpl(cfg);
    }

    /**
     * 加载核心配置文件
     */
    private void loadConfiguration() {
        // 创建SaxReader对象
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            // 读取输入流，返回Document对象
            doc = reader.read(inputStream);
            // 获取根节点
            Element root = doc.getRootElement();
            // 获取子节点(不考虑是不是直接子节点)：property
            List<Element> props = root.selectNodes("//property");
            for (Element prop : props) {
                //回去name的属性值
                String attrNameVal = prop.attributeValue("name");
                // 需要给哪个属性赋值
                if("driver".equals(attrNameVal)){
                    // 获取value属性的值
                    String attrValueVal = prop.attributeValue("value");
                    cfg.setDriver(attrValueVal);
                }
                // 需要给哪个属性赋值
                if("url".equals(attrNameVal)){
                    // 获取value属性的值
                    String attrValueVal = prop.attributeValue("value");
                    cfg.setUrl(attrValueVal);
                }
                // 需要给哪个属性赋值
                if("username".equals(attrNameVal)){
                    // 获取value属性的值
                    String attrValueVal = prop.attributeValue("value");
                    cfg.setUsername(attrValueVal);
                }
                // 需要给哪个属性赋值
                if("password".equals(attrNameVal)){
                    // 获取value属性的值
                    String attrValueVal = prop.attributeValue("value");
                    cfg.setPassword(attrValueVal);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        // 读取映射文件
        // 获取根节点
        Element root1 = doc.getRootElement();
        // 获取所有的mapper节点
        List<Element> mappers = root1.selectNodes("//mapper");
        //获取每一mapper中的属性
        for (Element mapper : mappers) {
            // 获取映射文件的路径
            String mapperPath = mapper.attributeValue("resource");
            loadMapperXmlConfiguration(mapperPath);
        }

    }

    /**
     * 读取映射文件的配置信息
     * @param mapperPath
     */
    private void loadMapperXmlConfiguration(String mapperPath){
        SAXReader reader = new SAXReader();
        // 获取xml的输入流
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(mapperPath);

        try {
            Document doc =  reader.read(inputStream);
            Element root = doc.getRootElement();
            // 获取全类名
            String namespace = root.attributeValue("namespace");
            // 获取跟节点中所有的select的子节点
            List<Element> selectList = root.elements("select");
            for (Element element : selectList) {
                // 获取属性id， 映射方法名称
                String id = element.attributeValue("id");
                // 获取返回值类型
                String resultType = element.attributeValue("resultType");
                // 获取方法名称
                String sql = element.getTextTrim();
                // 封装mapper对象
                Mapper mapper = new Mapper();
                mapper.setSql(sql);
                mapper.setResultType(resultType);
                // 映射的唯一标识符
                String mapperId = namespace +"."+ id;
                cfg.getMappers().put(mapperId, mapper);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }

}
