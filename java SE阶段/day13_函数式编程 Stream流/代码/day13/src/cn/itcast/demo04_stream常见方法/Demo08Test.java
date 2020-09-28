package cn.itcast.demo04_stream常见方法;

import java.util.ArrayList;
import java.util.List;

/*
    现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以
    下若干操作步骤：
    1. 第一个队伍只要名字为3个字的成员姓名；
    2. 第一个队伍筛选之后只要前3个人；
    3. 第二个队伍只要姓张的成员姓名；
    4. 第二个队伍筛选之后不要前2个人；
    5. 将两个队伍合并为一个队伍；
    6. 根据姓名创建 Person 对象；
    7. 打印整个队伍的Person对象信息
 */
public class Demo08Test {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");
        one.add("段先生");

        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        //1. 第一个队伍只要名字为3个字的成员姓名；
        List<String> oneA = new ArrayList<>();
        //遍历第一个集合，把里面名字是3个字的添加到oneA里面
        for (String s : one) {
            //判断如果长度是3，就添加到oneA中
            if (s.length() == 3) {
                oneA.add(s);
            }
        }

        //2. 第一个队伍筛选之后只要前3个人；
        List<String> oneB = new ArrayList<>();
        //遍历oneA,只取前三个放入到oneB中
        for(int i = 0; i < 3; i++) {
            String str = oneA.get(i);
            oneB.add(str);
        }

       //3. 第二个队伍只要姓张的成员姓名；
        List<String> twoA = new ArrayList<>();
        //遍历two集合，拿到里面的每个元素，如果姓张，就添加到oneA
        for (String s : two) {
            if(s.startsWith("张")) {
                twoA.add(s);
            }
        }

        //4. 第二个队伍筛选之后不要前2个人；
        List<String> twoB = new ArrayList<>();
        for(int i = 2; i < twoA.size(); i++) {
            //获取当前遍历到的元素
            String str = twoA.get(i);
            twoB.add(str);
        }

        //5. 将两个队伍合并为一个队伍；
        List<String> totalList = new ArrayList<>();
        totalList.addAll(oneB);//把oneB中的所有元素添加懂啊totalList中
        totalList.addAll(twoB);

        //6. 根据姓名创建 Person 对象；
        List<Person> personList = new ArrayList<>();
        for (String s : totalList) {
            personList.add(new Person(s));
        }

        //7. 打印整个队伍的Person对象信息
        for (Person p : personList) {
            System.out.println(p);
        }
    }
}
