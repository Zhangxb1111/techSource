package cn.itcast.demo03_game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
    斗地主的步骤：
        1. 准备牌
        2. 洗牌
        3. 发牌
        4. 看牌
 */
public class Demo01Game {
    public static void main(String[] args) {
        //1. 准备牌
        //创建一个ArrayList集合，保存扑克牌的编号
        ArrayList<Integer> poker = new ArrayList<>();
        //创建一个Map集合，保存编号和扑克牌的对应关系
        //key是编号，value是对应的扑克牌
        HashMap<Integer, String> map = new HashMap<>();
        //往ArrayList添加编号，往HashMap集合添加对应关系。
        //定义数组，保存花色
        String[] colors = {"♠", "♥", "♣", "♦"};
        //定义数组，保存数字
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "k", "A", "2"};
        //定义牌的编号，从0开始
        int index = 0;

        //对数字和花色进行组合，然后添加到对应的集合
        for (String num : nums) {
            for(String color : colors) {
                //往ArrayList集合中添加编号
                poker.add(index);
                //往Map集合中添加对应关系
                map.put(index, color + num);
                //把index++
                index++;
            }
        }
        //添加小王
        poker.add(index);
        map.put(index, "小王");
        index++;
        //添加大王
        poker.add(index);
        map.put(index, "大王");

        //2. 洗牌
        //调用Collections工具类的shuffle方法，打乱集合的顺序。
        //洗牌我们直接洗编号。
        Collections.shuffle(poker);

        //3. 发牌

        //定义三个集合，保存三个玩家手中的牌（真正保存的是编号）
        ArrayList<Integer> playOne = new ArrayList<>();
        ArrayList<Integer> playTwo = new ArrayList<>();
        ArrayList<Integer> playThree = new ArrayList<>();
        //定义一个集合，保存底牌
        ArrayList<Integer> diPai = new ArrayList<>();

        //开始发牌，真正发给每个玩家的都是编号。
        //遍历存放编号的集合，把里面的编号按照规律发给每一个玩家.
        //根据编号在集合中的索引进行发牌.
        for(int i = 0; i < poker.size(); i++) {
            //拿到每张牌（真正拿到的是编号）
            Integer card = poker.get(i);

            //处理底牌
            if(i >= 51) {// 51 52 53
                //如果不足三张牌了，就添加到底牌集合中
                diPai.add(card);
                continue;
            }
            //判断并发牌
            if (i % 3 == 0) {//如果这张牌的编号的索引  对3取余结果是0，就发给第一个人
                playOne.add(card);
            } else if(i % 3 == 1) {//如果这张牌的编号的索引 对3取余结果是1，就发给第二个人
                playTwo.add(card);
            } else {//如果这张牌的编号的索引 对3取余结果是2，就发给第3个人
                playThree.add(card);
            }
        }

        //4. 调用方法进行看牌
        lookCard("刘德华", playOne, map);
        lookCard("周星驰", playTwo, map);
        lookCard("周润发", playThree, map);
        lookCard("底牌", diPai, map);

    }

    /*
        定义方法，完成看牌。
        参数：
            玩家的姓名。
            玩家手里的牌（真正是编号）
            保存编号和牌对应关系的Map集合。

        步骤：
        在方法中，我们对玩家手中的编号进行排序。
        打印各种东西...
     */
    public static void lookCard(String name, ArrayList<Integer> list, HashMap<Integer, String> map) {
        //对玩家手里的牌进行排序
        Collections.sort(list);
        //对这个集合进行反转，就变成了从小到大进行排序
        Collections.reverse(list);//reverse方法用来对集合中的内容进行反转

        //开始打印
        System.out.print(name + ": ");
        //打印玩家的每一张牌
        //遍历ArrayList集合，也就是每个玩家手中的牌的编号，然后根据这个编号去Map集合中找到对应真正的牌。
        for(Integer cardNumber : list) {
            //调用map的get方法，根据牌的编号找到这张牌真正是是什么
            String card = map.get(cardNumber);
            System.out.print(card + " ");
        }

        System.out.println();
    }
}
