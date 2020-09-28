package cn.itcast.demo05_system;
/*
    System表示系统类，里面提供了大量和系统相关的方法，并且这些方法都是静态的。

    里面有一个方法，可以直接获取到当前操作系统对应的时间（毫秒值）
        static long currentTimeMillis​()： 返回当前时间（毫秒值）
 */
public class                                                                                                                                                     Demo01System {
    public static void main(String[] args) {
        //获取当前操作系统对应的毫秒值
        long millis = System.currentTimeMillis();

        System.out.println(millis);
    }
}
