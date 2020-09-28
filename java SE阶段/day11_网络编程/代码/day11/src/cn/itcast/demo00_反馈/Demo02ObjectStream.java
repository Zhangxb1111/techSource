package cn.itcast.demo00_反馈;
//java编译器对于变量，在编译时期是不知道具体的值的。
public class Demo02ObjectStream {
    public static void main(String[] args) {
        int i;

        int num = 3;
        if(num > 0) {
            i = 10;
        } else {
            i = 3;
        }


        System.out.println(i);
    }
}
