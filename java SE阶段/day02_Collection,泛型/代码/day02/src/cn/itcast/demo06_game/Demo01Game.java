package cn.itcast.demo06_game;

import java.security.Policy;
import java.util.ArrayList;
import java.util.Collections;

/*
    斗地主案例的分析：
        1. 准备牌
            a. 创建一个集合，用来保存所有的扑克牌。
            b. 把所有的扑克牌添加到集合中。
        2. 洗牌
            洗牌就是打乱顺序，我们只要将集合中的元素的顺序打乱就可以了
            在Collections（工具类）中，有一个方法，可以打乱顺序，叫做shuffle
            static void shuffle​(List<?> list)： 打乱顺序
        3. 发牌
            a. 定义三个集合，保存三个玩家手中的牌。
            b. 定义一个集合，用来保存底牌。
            c. 开始发牌， 第一张牌发给第一个人，第二章牌发给第二个人，第三张牌发给第三个人，第四张牌发给第一个人..
               索引为 0, 3, 6, 9...的牌要发给第一个人。（索引 % 3 == 0）
               索引为 1, 4, 7, 10...的牌要发给第二个人  （索引 % 3 == 1）
               索引为 2，5, 8, 11...的牌要发给第三个人。 （索引 % 3 == 2）
        4. 看牌
            遍历集合。
 */
public class Demo01Game {
    public static void main(String[] args) {
        //1. 准备牌
        //a. 创建一个集合，用来保存所有的扑克牌。
        ArrayList<String> poker = new ArrayList<>();
        //b. 把所有的扑克牌添加到集合中。
        //定义数组，用来保存所有扑克牌的花色
        String[] colors = {"♠", "♥", "♣", "♦"};
        //定义数组保存所有的点数
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        //使用循环，对这两个数组进行组合
        for (String num : nums) {
            for(String color : colors) {
                //进行组合并且添加到集合中
                poker.add(color + num);
            }
        }
        //添加大小王
        poker.add("小王");
        poker.add("大王");
        //2. 洗牌
        Collections.shuffle(poker);

        //3. 发牌
        //a. 定义三个集合，保存三个玩家手中的牌。
        ArrayList<String> playOne = new ArrayList<>();
        ArrayList<String> playTwo = new ArrayList<>();
        ArrayList<String> playThree = new ArrayList<>();

        //b. 定义一个集合，用来保存底牌。
        ArrayList<String> diPai = new ArrayList<>();

        //c. 开始发牌，根据索引发牌
        //因为要使用索引，所以需要使用普通for
        for(int i = 0; i < poker.size(); i++) {
            //获取到这张扑克牌
            String card = poker.get(i);

            //判断剩下的牌是否小于等于三张，如果是，要放入到底牌中.
            if (i >= 51) {//如果不足三张，放入底牌
                diPai.add(card);
                continue;
            }

            //判断这张扑克牌发给谁
            if (i % 3 == 0) {//如果索引是0,3,6,9... 就发给第一个玩家
                playOne.add(card);
            } else if (i % 3 == 1) {//  索引为 1, 4, 7, 10...的牌要发给第二个人  （索引 % 3 == 1）
                playTwo.add(card);
            } else {//其他情况，索引 % 3 == 2
                //索引为 2，5, 8, 11...的牌要发给第三个人。 （索引 % 3 == 2）
                playThree.add(card);
            }
        }
        //4. 看牌
        lookCard("周润发", playOne);
        lookCard("周星驰", playTwo);
        lookCard("刘德华", playThree);
        lookCard("底牌", diPai);
    }

    /*
        定义方法用来看牌
     */
    public static void lookCard(String name, ArrayList<String> list) {
        System.out.print(name + ": ");
        //遍历这个集合
        for(String card : list) {
            System.out.print(card + " ");
        }

        System.out.println();
    }
}
