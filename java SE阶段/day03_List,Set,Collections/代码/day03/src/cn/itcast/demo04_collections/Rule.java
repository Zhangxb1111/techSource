package cn.itcast.demo04_collections;

import java.util.Comparator;

public class Rule implements Comparator<Student>{
    /*
        如果返回值是0，表示o1和o1相等
        如果返回值是负数，表示o1比o2小
        如果返回值是整数，表示o1比o2大

        升序就是1减2
        降序就是2减1
     */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}
