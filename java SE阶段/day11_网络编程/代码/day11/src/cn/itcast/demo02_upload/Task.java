package cn.itcast.demo02_upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class Task implements Runnable{

    private Socket socket;

    public Task(Socket socket) {
        this.socket = socket;
    }


    //run方法是线程要执行的任务，线程执行的任务是上传任务。
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
}
