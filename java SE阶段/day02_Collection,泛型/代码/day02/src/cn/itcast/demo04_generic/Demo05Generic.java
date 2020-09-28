package cn.itcast.demo04_generic;
/*
    测试类
 */
public class Demo05Generic {
    public static void main(String[] args) {
        //创建Factory对象
        Factory<Phone> f = new Factory<>();

        //调用方法
        //此时确定出来泛型方法中的泛型是Phone类型
        Phone p =f.getSame(new Phone());
        Pad pad = f.getSame(new Pad());
        String str = f.getSame("你好");

        //Phone p2 = f.<Phone>function(); 了解
    }
}
