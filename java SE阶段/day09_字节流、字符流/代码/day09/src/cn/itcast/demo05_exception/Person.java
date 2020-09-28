package cn.itcast.demo05_exception;

public class Person implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("close...");
    }
}
