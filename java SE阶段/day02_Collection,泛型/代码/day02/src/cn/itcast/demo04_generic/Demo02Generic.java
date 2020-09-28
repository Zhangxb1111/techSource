package cn.itcast.demo04_generic;

import java.util.ArrayList;

/*
    在java中的泛型是伪泛型。

    泛型只在编译时期有效，一旦到了运行时期，泛型就会消失，俗称泛型擦除。
 */
public class Demo02Generic {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("你好");
        list.add("我好");
        list.add("大家好");
        for(String str : list) {
            System.out.println(str);
        }
    }
}
