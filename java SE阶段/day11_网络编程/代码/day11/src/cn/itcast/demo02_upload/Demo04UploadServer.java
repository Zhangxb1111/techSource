package cn.itcast.demo02_upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/*
    上传案例Lambda表达式版本
 */
@SuppressWarnings("all")
public class Demo04UploadServer {
    public static void main(String[] args) throws IOException {
        //1. 创建ServerSocket服务器对象
        ServerSocket serverSocket = new ServerSocket(9527);
        while(true) {
            //2. 调用accept方法，监听并获取客户端的Socket。
            Socket socket = serverSocket.accept();
            //如果监听到了客户端的请求，就开启一个新的线程给这个请求执行上传任务
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream in = socket.getInputStream();
                        FileOutputStream fos = new FileOutputStream("d:\\server\\" + UUID.randomUUID().toString() + ".jpg");

                        byte[] bArr = new byte[1024];
                        int len;
                        while((len = in.read(bArr)) != -1) {
                            fos.write(bArr, 0 , len);
                        }
                        fos.close();

                        OutputStream out = socket.getOutputStream();

                        out.write("上传成功".getBytes());

                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
