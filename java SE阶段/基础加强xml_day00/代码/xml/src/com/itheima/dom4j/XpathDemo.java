package com.itheima.dom4j;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XpathDemo {

    public static void main(String[] args) throws Exception{
        /*
          Dom4j 结合 路径表达式(xpath)  寻找节点
         */
        SAXReader saxReader = new SAXReader();
//
        String path = XpathDemo.class.getClassLoader().getResource("student.xml").getFile();

        File file = new File(path);

        Document document = saxReader.read(file);

        ///.结合xpath语法查询
        //      查询所有student标签
        List<Node> nodes = document.selectNodes("//student");
//        nodes.forEach(System.out::println);
        for (Node node : nodes) {
            System.out.println(node);
        }
        System.out.println("----------------------------------");
        // 查询所有student标签下的name标签
        List<Node> node2s = document.selectNodes("//student/name");
        //        nodes.forEach(System.out::println);
        for (Node node : node2s) {
            System.out.println(node);
        }


        System.out.println("----------------------------------");
        //查询student标签下带有id属性的name标签
        List<Node> node3s = document.selectNodes("//student/name[@id]");
        //        nodes.forEach(System.out::println);
        for (Node node : node3s) {
            System.out.println(node);
        }

        //查询student标签下带有id属性的name标签 并且id属性值为itcast
        System.out.println("----------------------------------");
        List<Node> node4s = document.selectNodes("//student/name[@id='itcast']");
        //        nodes.forEach(System.out::println);
        for (Node node : node4s) {
            System.out.println(node);
        }
    }
}
