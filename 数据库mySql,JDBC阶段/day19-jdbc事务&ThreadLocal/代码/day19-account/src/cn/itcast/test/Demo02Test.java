package cn.itcast.test;

import cn.itcast.utils.ConnectionManager;

public class Demo02Test {
    public static void main(String[] args) throws Exception {
        System.out.println(ConnectionManager.getConnection());
        method();

        new Thread(() -> {
            try {
                method();
                method();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void method() throws Exception {
        System.out.println(ConnectionManager.getConnection());
    }
}
