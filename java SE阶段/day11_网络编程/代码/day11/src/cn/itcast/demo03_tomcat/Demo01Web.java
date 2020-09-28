package cn.itcast.demo03_tomcat;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo01Web {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(10000);
        while(true) {
            //监听并获取客户端的请求
            Socket socket = serverSocket.accept();
            System.out.println("收到了请求");
            new Thread(() -> {
                try {
                    //服务器收到请求之后，回给客户端一些数据.
                    //因为客户端是浏览器，所以要满足http协议的一些要求。
                    //http协议前三行是固定的， 前两行是固定内容，第三行是固定的空行
                    OutputStream out = socket.getOutputStream();
                    out.write("HTTP/1.1 200 OK\r\n".getBytes()); //第一行
                    out.write("Content-Type:text/html\r\n\r\n".getBytes()); //第二行和第三行

                    //写完上面的内容后，再给浏览器写一个html文件的内容。

                    //创建一个FileInputStream，用来读取index.html
                    FileInputStream fis = new FileInputStream("index.html");
                    //开始读写，一次读写一个字节数组
                    byte[] bArr = new byte[1024];
                    int len;
                    while((len = fis.read(bArr)) != -1) {
                        out.write(bArr, 0, len);
                    }
                    fis.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();


        }

    }
}
