package cn.itcast.demo01_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    tcp案例中的服务器端

    java中，有一个类可以表示服务器，这个类叫做ServerSocket。

    构造方法：
        ServerSocket​(int port)： 参数需要传递一个端口号。 此端口号表示的是这个服务器程序的端口号。

    其他方法：
        Socket accept​()： 监听并获取客户端Socket。 等待客户端的请求，如果客户端发来请求，就可以获取到客户端Socket

    TCP服务器端实现步骤：
        1. 创建一个ServerSocket对象，这个对象表示的是服务器
        2. 调用ServerSocket的accept方法，监听并获取一个客户端Socket对象。
        3. 通过客户端Socket对象，获取输入流，用来读取数据。
        4. 调用输入流的read方法，读取数据。
        5. 通过客户度Socket对象，获取输出流，用来写数据。
        6. 调用write方法，写数据。
        7. 释放资源
 */
public class Demo02Server {
    public static void main(String[] args) throws IOException {
        //1. 创建一个ServerSocket对象，这个对象表示的是服务器
        ServerSocket serverSocket = new ServerSocket(9527);
        //2. 调用ServerSocket的accept方法，监听并获取一个客户端Socket对象。
        Socket socket = serverSocket.accept();
        //3. 通过客户端Socket对象，获取输入流，用来读取数据。
        InputStream in = socket.getInputStream();
        //4. 调用输入流的read方法，读取数据。
        byte[] bArr = new byte[1024];
        int len = in.read(bArr);
        System.out.println(new String(bArr, 0, len));
        //5. 通过客户端Socket对象，获取输出流，用来写数据。
        OutputStream out = socket.getOutputStream();
        //6. 调用write方法，写数据。
        out.write("我收到了消息，thank you".getBytes());
        //7. 释放资源
        socket.close();
        serverSocket.close();
    }
}
