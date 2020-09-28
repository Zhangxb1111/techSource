package cn.itcast.demo01_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    练习：使用Map集合保存数据，key是Student类型， value是这个学生对应的家庭住址。

    Student有两个属性，姓名，年龄。

    注意： 如果两个Student对象属性完全相同，就当成是同一个学生对象。

    HashMap的key判断唯一性的原理和HashSet一模一样。
    先调用hashCode比较两个对象的哈希值。
    再调用equals比较两个对象是否相同。

    HashSet内部就是一个HashMap，只使用到了HashMap中的key。


    如果想要实现两个对象的属性相同就当成是同一个对象，则要重写hashCode和equals方法

 */
public class Demo04Map {
    public static void main(String[] args) {
        // 创建一个Map集合，key是Student对象，value是字符串类型的家庭住址
        Map<Student,String> map = new HashMap<>();


        //往Map集合中添加键值对
        map.put(new Student("小明", 12), "火星");
        map.put(new Student("小龙女", 18), "古墓");
        map.put(new Student("尹志平", 20), "古墓的上面");

        //如果key已经存在，就覆盖
        map.put(new Student("小龙女", 18), "龙宫");

        //对这个Map集合进行遍历，使用keySet的方式进行遍历

        //得到存放所有key的set集合
        Set<Student> set = map.keySet();

        //遍历这个set集合，拿到里面的每一个key
        for(Student key : set) {
            //根据key获取value
            String value = map.get(key);
            System.out.println(key + "--" + value);
        }
    }
}
