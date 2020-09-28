package cn.itcast.demo00_ddos;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class Task implements Runnable {



    @Override
    public void run() {
        try {
            URL url = new URL("http://www.baidu.com");
            URLConnection conn = url.openConnection();
            System.out.println("发包成功！");
            BufferedInputStream bis = new BufferedInputStream(
                    conn.getInputStream());
            byte[] bytes = new byte[1024 * 10];
            int len = -1;
            //StringBuilder sb = new StringBuilder();

            if (bis != null) {
                if ((len = bis.read(bytes)) != -1) {
                    //sb.append(new String(bytes, 0, len));
                    System.out.println(new String(bytes, 0, len));
                    System.out.println("攻击成功！");
                    bis.close();
                }
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
