package cn.itcast.demo02_upload;

import java.io.*;
import java.net.Socket;

/*
    上传案例的客户端.

    步骤：
        1. 创建一个字节输入流FileInputStream，用来读取自己电脑上的文件。
        2. 创建客户端Socket，并指定要连接的服务器和端口号。
        3. 调用Socket的getOutputStream，用来向服务器写数据。
        4. 一边读一边写，每从本地读取一个字节数组，就将读取到的内容写到服务器。
        5. 调用Socket的getInputStream，获取一个输入流，用来读取服务器发送过来的数据。
        6. 调用read方法，读取数据。
 */
public class Demo01UploadClient {
    public static void main(String[] args) throws IOException {
        //1. 创建一个字节输入流FileInputStream，用来读取自己电脑上的文件。
        FileInputStream fis = new FileInputStream("d:\\client\\aa.jpg");
        //2. 创建客户端Socket，并指定要连接的服务器和端口号。
        Socket socket = new Socket("127.0.0.1", 9527);
        //3. 调用Socket的getOutputStream，获取输出流，用来向服务器写数据。
        OutputStream out = socket.getOutputStream();
        //4. 一边读一边写，每从本地读取一个字节数组，就将读取到的内容写到服务器。
        byte[] bArr = new byte[1024];
        int len;
        while((len = fis.read(bArr)) != -1) {
            out.write(bArr, 0, len);
        }
        //如果循环结束，就意味着不再向服务器写数据， 就告诉服务器，我以后不会再写了。
        socket.shutdownOutput();

        fis.close();

        //5. 调用Socket的getInputStream，获取一个输入流，用来读取服务器发送过来的数据。
        InputStream in = socket.getInputStream();
        //6. 调用read方法，读取数据。
        len = in.read(bArr);
        System.out.println(new String(bArr, 0, len));

        //释放资源
        socket.close();

    }
}
