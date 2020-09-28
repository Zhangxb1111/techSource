package cn.itcast.demo12_常用的函数式接口;

import java.util.function.Consumer;

/*
    下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来。要求将打印姓
    名的动作作为第一个 Consumer 接口的Lambda实例，将打印性别的动作作为第二个 Consumer 接口的Lambda实
    例，将两个 Consumer 接口按照顺序“拼接”到一起。



    使用两个Consumer，一个打印姓名，一个打印性别。

    最终打印结果
    姓名： 迪丽热巴  性别：女
    姓名： 古力娜扎  性别：女
    姓名： 马尔扎哈  性别：男

 */
public class Demo04ConsumerTest {
    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };

        method(s -> System.out.print("姓名：" + s.split(",")[0]),
                s -> System.out.println(" 性别：" + s.split(",")[1]),
                array);

    }

    //定义方法，用来打印
    public static void method(Consumer<String> one, Consumer<String> two, String[] arr) {
        //遍历数组，拿到数组中的每一个元素
        for(String s : arr) {
            //打印姓名
            //one.accept(s);
            //打印性别
            //two.accept(s);
            //合并成一个Consumer
            one.andThen(two).accept(s);
        }

    }
}
