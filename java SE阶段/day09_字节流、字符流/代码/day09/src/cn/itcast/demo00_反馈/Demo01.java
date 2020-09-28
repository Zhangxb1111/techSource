package cn.itcast.demo00_反馈;

public class Demo01 {
    public static void main(String[] args) {
        System.out.println(getCount(20));
    }
    /*
        不死神兔
        前两个月都是1对
        后面就是前两个月的和
     */
    public static int getCount(int month) {
        if(month == 1 || month == 2) {
            return 1;
        }
        return getCount(month - 1) + getCount(month - 2);
    }
}
