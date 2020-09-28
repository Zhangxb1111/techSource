package cn.itcast.demo01_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
    数组当中有多条“姓名+性别”的信息如下，请通过 Predicate 接口的拼装将符合要求的字符串筛选到集合
    ArrayList 中，需要同时满足两个条件：
    1. 必须为女生；
    2. 姓名为4个字。
 */
public class Demo05PredicateTest {
    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女" };

        method(s -> s.split(",")[1].equals("女"),
                s -> s.split(",")[0].length() == 4,
                array);
    }

    /*
        参数Predicate one： 验证这个字符串对应的性别。
        参数Predicate two： 验证这个字符串对应的姓名是否为4个字
        参数数组： 表示获取哪个数组中的内容
     */
    public static void method(Predicate<String> one, Predicate<String> two, String[] array) {
        //创建集合，并且遍历数组，对数组中的元素进行判断，把满足要求的元素添加到集合中

        //创建集合
        List<String> list = new ArrayList<>();
        //遍历数组
        for (String s : array) {
            /*
            boolean flagOne = one.test(s);//用来验证这个字符串对应的性别
            boolean flagTwo = two.test(s);//用来验证这个字符串对应的姓名长度
            boolean result = flagOne && flagTwo;
            if(result) {
                list.add(s);
            }
            */
            //one.test(s) && two.test(s)
            boolean result = one.and(two).test(s);
            if(result) {
                list.add(s);
            }
        }

        System.out.println(list);
    }
}
