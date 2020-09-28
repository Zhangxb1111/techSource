package com.itheima.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Dom4JDemo {

    public static void main(String[] args) throws DocumentException {
        //解析  bean.xml文件
        //1:创建SAXReader对象 用来读取bean.xml
        SAXReader saxReader = new SAXReader();
        //2: 使用读取方法 将文件读到内存中 形成document对象
        Document document = saxReader.read("xml/bean.xml");
        //3:获取根元素
        Element rootElement = document.getRootElement();
        //4:获取根元素下 所有的 bean元素
        List<Element> beanElements =rootElement.elements();
        //5: 遍历得到每一个bean元素
        for (Element beanElement : beanElements) {
            // beanElement 每一个bean元素
            // 解析 bean元素中的 className 属性
            String className = beanElement.attributeValue("className");
            System.out.println("className:"+className);

            //6： beanElement 有 很多property元素 获取该bean元素下的所有peoperty元素
            List<Element> ppElements = beanElement.elements();
            // 7:遍历 得到每一个property元素
            for (Element ppElement : ppElements) {
                // 解析 里面的 name  value
                String name = ppElement.attributeValue("name");
                String value = ppElement.attributeValue("value");
                System.out.println(name+"   "+value);

            }
        }
    }
}
