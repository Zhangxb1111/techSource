package cn.itcast.demo04_ext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo01Map {
    public static void main(String[] args) {
        //创建Map集合
        Map<String, String> map = new HashMap<>();
        //调用put方法，向Map集合中添加键值对
        map.put("it001", "林冲");
        map.put("it002", "金莲");
        map.put("it003", "西门大官人");

        Set<Map.Entry<String, String>> set = map.entrySet();

        for (Map.Entry<String, String> entry : set) {
            System.out.println(entry.getClass());
        }
    }
}
