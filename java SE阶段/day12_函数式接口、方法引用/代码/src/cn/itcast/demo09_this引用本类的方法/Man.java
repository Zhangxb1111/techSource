package cn.itcast.demo09_this引用本类的方法;

public class Man {

    public void buy() {
        System.out.println("买了一个500平米的大house");
    }


    public void mary(Rich rich) {
        rich.buy();
    }

    public void beHappy() {
        //mary(() -> System.out.println("买了一个二百五十克拉的大钻戒"));
        //mary(() -> buy());

        mary(this::buy);
    }
}
