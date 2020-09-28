package cn.itcast.demo01_thread;

public class MyThreadMethod extends Thread{

    public MyThreadMethod() {
        super();
    }

    public MyThreadMethod(String name) {
        super(name);
    }

    @Override
    public void run() {
        //调用getName方法，获取线程的名字
        System.out.println(getName());
    }
}
