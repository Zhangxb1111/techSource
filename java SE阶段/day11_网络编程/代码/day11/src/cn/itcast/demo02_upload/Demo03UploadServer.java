package cn.itcast.demo02_upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/*
    使用多线程完成服务器端。

 */
@SuppressWarnings("all")
public class Demo03UploadServer {
    public static void main(String[] args) throws IOException {
        //1. 创建ServerSocket服务器对象
        ServerSocket serverSocket = new ServerSocket(9527);
        while(true) {
            //2. 调用accept方法，监听并获取客户端的Socket。
            Socket socket = serverSocket.accept();
            //如果监听到了客户端的请求，就开启一个新的线程给这个请求执行上传任务
            //创建线程任务对象
            Task t = new Task(socket);
            //创建新的线程，执行这个任务
            new Thread(t).start();
        }
    }
}
