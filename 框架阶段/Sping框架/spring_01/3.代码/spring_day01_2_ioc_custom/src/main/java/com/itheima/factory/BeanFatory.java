package com.itheima.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 1.读取配置文件
 * 2.创建对象
 */
public class BeanFatory {

    private static  Map<String ,String > map = new HashMap<String ,String>();
    //静态的代码块
    static {
        
        SAXReader reader = new SAXReader();
        //获取配置文件的输入流
        InputStream inputStream = BeanFatory.class.getClassLoader().getResourceAsStream("bean.xml");
        try {
            //读取文档对象
            Document doc = reader.read(inputStream);
            //读取根节点
            Element root = doc.getRootElement();
            //读取根节点中的子节点:获取所有的叫bean 的子节点
            List<Element> beanList = root.elements("bean");

            for (Element element : beanList) {
                //获取bean节点中id属性值
                String id = element.attributeValue("id");
                //获取bean节点中class属性值
                String clazz = element.attributeValue("class");

                map.put(id ,clazz);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param beanName  一般与id值是一致的
     * @return
     */
    public static Object getBean(String beanName){
        //从map集合中根据key获取vale
        String className = map.get(beanName);
        //通过反射创建对象
        try {
            //返回的是字节码文件
            Class clazz = Class.forName(className);
            Object obj = clazz.newInstance();
            return obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
