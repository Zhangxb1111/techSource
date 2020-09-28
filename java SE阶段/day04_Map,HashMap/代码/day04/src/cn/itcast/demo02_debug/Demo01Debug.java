package cn.itcast.demo02_debug;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
    bug：本意是小虫子，在计算机世界中指的是出现了问题。
    debug： 解决bug。

    断点： 可以让程序在运行的时候停下来。

    如何加断点： 想让代码在哪一行停下来，就在哪一行代码的左边单击。

    如何运行带有断点的程序： debug ...

    代码往下移动一行： F8
    如果想要进入到方法中： F7
    释放断点，把剩下的代码一下子执行完： F9
 */
@SuppressWarnings("all") //注解， 这个注解的作用是抑制警告。
public class Demo01Debug {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请您键盘录入一个字符串");
        String str = sc.nextLine();

        printCount(str);
    }

    /*
        新建方法，统计一个字符串中每个字符出现的次数并打印
     */
    public static void printCount(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        Set<Character> set = map.keySet();
        for(Character key : set) {
            System.out.println(key + ":" + map.get(key));
        }
    }
}
