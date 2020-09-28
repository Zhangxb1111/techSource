package cn.itcast.demo06_stringbuilder;
/*
    StringBuilder中常用的方法：
        StringBuilder append​(任意类型)： 将任意类型的数据拼接到此StringBuilder上面。返回值是调用者本身。
        String toString​()： 将StringBuilder对象转成字符串。


    String和StringBuilder的相互转换
        String -> StringBuilder：
            使用StringBuilder的有参构造创建对象即可
             StringBuilder​(String str)： 根据指定的字符串创建一个StringBuilder对象。
        StringBuilder -> String:
            使用StringBuilder的toString方法。
 */
public class Demo03StringBuilderMethod {
    public static void main(String[] args) {
        //创建一个StringBuilder对象
        StringBuilder sb = new StringBuilder();
        //调用append方法，在这个sb对象上面拼接各种类型的数据
        //StringBuilder newSb = sb.append("你好");
        //System.out.println("sb:" + sb);
        //System.out.println("newSb:" + newSb);

        /*
        sb.append(10);
        sb.append(3.14);
        sb.append(false);
        sb.append('a');
        sb.append("你好");
        System.out.println("sb:" + sb);
        */

        //链式编程
        sb.append("你好").append(10).append(3.14).append(false);
        System.out.println("sb:" + sb);


        //将StringBuilder转成字符串
        //String toString​()： 将StringBuilder对象转成字符串。
        String str = sb.toString();
        System.out.println("str:" + str);

    }
}
