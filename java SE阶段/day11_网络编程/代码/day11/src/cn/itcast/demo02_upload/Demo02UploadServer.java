package cn.itcast.demo02_upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/*
    上传案例的服务器端

    步骤：
        1. 创建ServerSocket服务器对象
        2. 调用accept方法，监听并获取客户端的Socket。
        3. 调用Socket对象的getInputStream得到输入流，用来读取客户端发来的数据。
        4. 创建FileOutputStream用来向自己电脑（服务器端）写数据
        5. 开始读写，一次读写一个字节数组，每读取一个字节数组，就把读取到的字节数组写到本地。
        6. 调用Socket对象的getOutputStream得到输出流，用来向客户度写数据。
        7. 调用输出流的write方法，向客户端发送。 （上传成功）
        8. 释放资源
 */
public class Demo02UploadServer {
    public static void main(String[] args) throws IOException {
        //1. 创建ServerSocket服务器对象
        ServerSocket serverSocket = new ServerSocket(9527);
        while(true) {
            //2. 调用accept方法，监听并获取客户端的Socket。
            Socket socket = serverSocket.accept();
            //System.out.println(socket.getInetAddress()); 获取客户端的ip

            //3. 调用Socket对象的getInputStream得到输入流，用来读取客户端发来的数据。
            InputStream in = socket.getInputStream();
            //4. 创建FileOutputStream用来向自己电脑（服务器端）写数据
            //FileOutputStream fos = new FileOutputStream("d:\\server\\" + System.currentTimeMillis() + ".jpg");
            FileOutputStream fos = new FileOutputStream("d:\\server\\" + UUID.randomUUID().toString() + ".jpg");

            //5. 开始读写，一次读写一个字节数组，每读取一个字节数组，就把读取到的字节数组写到本地。
            byte[] bArr = new byte[1024];
            int len;
            while((len = in.read(bArr)) != -1) {
                fos.write(bArr, 0 , len);
            }
            fos.close();

            //6. 调用Socket对象的getOutputStream得到输出流，用来向客户度写数据。
            OutputStream out = socket.getOutputStream();
            //7. 调用输出流的write方法，向客户端发送。 （上传成功）
            out.write("上传成功".getBytes());

            //释放资源
            socket.close();
        }
    }
}
