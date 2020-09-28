package cn.itcast.demo02_bufferedstream;

import java.io.*;

/*
    字符缓冲流中独有的方法（重要）

    BufferedWriter中有一个方法，可以实现一个跨平台的换行。
        void newLine​()

    BufferedReader中有一个方法，可以每次读取一行数据。
        String readLine​()： 读取一行数据。返回值是读取到的这行数据。如果读取结束，返回null
        readLine方法不会读取换行符，如果要换行，需要我们手动实现
 */
public class Demo02BufferedStream {
    public static void main(String[] args) throws IOException {
        method2();
    }

    //String readLine​()： 读取一行数据。
    public static void method2() throws IOException {
        //创建一个缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("file02.txt"));
        //调用readLine方法，一次读取一行数据
        //使用循环读取，一次读取一行
        String line; //用来接收读取到的这行数据
        while ((line = br.readLine()) != null) {
            /*
                条件做了哪些事情
                1. 先调用readLine方法，读取到了一行数据。
                2. 把读取到的这行数据返回赋值给line
                3. 判断line是否不等于null，如果不是null表示读取到了数据，那么就对读取到的数据进行处理
             */
            System.out.println(line);
        }

        /*
        String line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);

        line = br.readLine();
        System.out.println(line);
        */

        //释放资源
        br.close();
    }

    //void newLine​()跨屏台的换行
    public static void method1() throws IOException {
        //创建缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("file02.txt"));
        //调用write方法，向文件中写入两句诗
        bw.write("窗寒西岭千秋血");
        bw.newLine();
        bw.write("门泊东吴万里船");

        //刷新
        bw.flush();
        //关闭
        bw.close();
    }
}
