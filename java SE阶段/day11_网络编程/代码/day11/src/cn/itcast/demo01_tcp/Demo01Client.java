package cn.itcast.demo01_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
    TCP 案例中的客户端。

    在java中，可以使用一个类表示客户端，这个类叫做Socket

    构造方法：
        Socket​(String host, int port)： 参数host表示要连接哪台计算机。 参数port表示连接的是哪个应用程序。
                                         因为Socket表示的是客户端，客户端要连接的是服务器，所以参数要传递服务器的ip和服务器程序的端口号.

    其他方法：
        OutputStream getOutputStream​()：获取一个输出流对象。　用来向服务器发送数据（写数据）
        InputStream getInputStream​(): 获取一个输入流对象， 用来读取服务器发送过来的数据（接收数据）
        void close​()：释放资源

    TCP案例客户端的实现步骤：
        1. 创建一个客户端Socket对象，并指定要连接服务器的ip地址和端口号。
        2. 调用getOutputStream获取一个输出流，用来向服务器写数据。
        3. 调用输出流的write方法，向服务器发送消息。
        4. 调用getInputStream获取一个输入流，用来读取服务器的数据。
        5. 调用输入流的read方法，读取服务器发送过来的消息。
        6. 关闭Socket
 */
public class Demo01Client {
    public static void main(String[] args) throws IOException {
        //1. 创建一个客户端Socket对象，并指定要连接服务器的ip地址和端口号。
        //当创建Socket对象的时候，会尝试和服务器建立连接，如果建立连接失败，则会抛出异常
        Socket socket = new Socket("127.0.0.1", 9527);

        //2. 调用getOutputStream获取一个输出流，用来向服务器写数据。
        OutputStream out = socket.getOutputStream();

        //3. 调用输出流的write方法，向服务器发送消息。
        out.write("TCP I'm Coming".getBytes());

        //4. 调用getInputStream获取一个输入流，用来读取服务器的数据。
        InputStream in = socket.getInputStream();

        //5. 调用输入流的read方法，读取服务器发送过来的消息。
        byte[] bArr = new byte[1024];
        int len = in.read(bArr);

        System.out.println(new String(bArr, 0, len));

        //6. 释放资源
        socket.close();
    }
}
