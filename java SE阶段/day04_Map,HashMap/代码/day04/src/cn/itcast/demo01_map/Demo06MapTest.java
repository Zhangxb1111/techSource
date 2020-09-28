package cn.itcast.demo01_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
    练习： 计算一个字符串中每个字符出现次数

    比如 aaabbcccc 可以统计出a出现了3次，b出现了2次，c出现了4次

    思路：
        1. 键盘录入一个字符串。
        2. 定义一个Map集合， key是字符， value是数字表示这个字符出现的次数。
        3. 遍历字符串，拿到字符串中的每个字符。
        4. 判断Map集合中是否有这个字符，如果没有，表示没有统计过，如果有表示已经统计过。
           如果有， 获取到这个字符出现的次数，然后把这个次数+1，再重新保存到Map集合中。
           如果没有， 把这个字符放入到Map集合，次数是1.

 */
@SuppressWarnings("all")
public class Demo06MapTest {
    public static void main(String[] args) {
        //1. 键盘录入一个字符串。
        Scanner sc = new Scanner(System.in);
        System.out.println("请您键盘录入一个字符串");
        String str = sc.nextLine();

        //2. 定义一个Map集合， key是字符， value是数字表示这个字符出现的次数。这个Map集合用来统计.
        Map<Character, Integer> map = new HashMap<>();

        //3. 遍历字符串，拿到字符串中的每个字符。
        for (int i = 0; i < str.length(); i++) {
            //拿到每一个字符
            char c = str.charAt(i);
            //4. 判断Map集合的key中有没有这个字符
            //在map集合中有一个方法，可以判断是否包含这个键，这个方法叫做containsKey

            if (map.containsKey(c)) {
                //如果有， 获取到这个字符出现的次数，然后把这个次数+1，再重新保存到Map集合中。
                //int count = map.get(c);
                //map.put(c, count + 1);
                //使用一句话表示
                map.put(c, map.get(c) + 1);
            } else {
                //如果没有， 把这个字符放入到Map集合，次数是1.
                map.put(c, 1);
            }

            //扩展写法
            //map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);

        }

        //遍历Map集合
        Set<Character> set = map.keySet();
        for(Character key : set) {
            System.out.println(key + ":" + map.get(key));
        }
    }
}
