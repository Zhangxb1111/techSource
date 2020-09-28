package cn.itcast.demo04_generic;
/*
    对泛型类进行使用
 */
public class Demo04Generic {
    public static void main(String[] args) {
        //使用这个类创建对象
        //此时确定出来的，Factory中的泛型是Phone类型
        Factory<Phone> f = new Factory<>();

        //调用method方法
        Phone p = f.method(new Phone());

        //调用call方法
        p.call();

        //再创建一个
        Factory<Pad> f2 = new Factory<>();
        Pad pad = f2.method(new Pad());
        pad.play();

    }
}
