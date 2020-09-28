package cn.itcast.demo02_bufferedstream;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
    给出师表中的内容恢复顺序。

    文件中内容的特点：
        1. 内容是 序号.语句
        2. 序号是唯一的不重复的

    思路：
        1. 定义一个Map集合， key为序号，value为后面的内容
        2. 创建一个字符缓冲输入流，用来读取
        3. 开始读，一次读取一行数据。
        4. 每读取到一行数据，那么就根据.进行切割，得到这句话的序号以及内容。
        5. 把序号作为key，把内容作为value放入到Map集合。
        6. 创建一个输出流，用来写
        7. 使用循环，从1开始，最大的Map集合的长度。根据数字获取对应的value。
        8. 把这些内容使用.分隔写入到新的文件中
        9. 换行
        10. 刷新
        11. 关流
 */
public class Demo03BufferedStreamTest {
    public static void main(String[] args) throws IOException {
        //1. 定义一个Map集合， key为序号，value为后面的内容
        Map<Integer, String> map = new HashMap<>();
        //2. 创建一个字符缓冲输入流，用来读取
        BufferedReader br = new BufferedReader(new FileReader("出师表.txt"));
        //3. 开始读，一次读取一行数据。
        String line;
        while((line = br.readLine()) != null) {
            //line里面保存的就是读取到的这行数据
            //4. 每读取到一行数据，那么就根据.进行切割，得到这句话的序号以及内容。
            //split方法是根据正则表达式切割。 而.是正则表达式的特殊字符。 所以需要转义
            String[] strArr = line.split("\\.");
            //数组中索引为0的元素是 序号。 数组中索引为1的元素是内容
            Integer id = Integer.parseInt(strArr[0]);
            String content = strArr[1];
            //5. 把序号作为key，把内容作为value放入到Map集合。
            map.put(id, content);
        }
        //释放资源
        br.close();

        //6. 创建一个输出流，用来写
        BufferedWriter bw = new BufferedWriter(new FileWriter("outTeacherTable.txt"));

        //7. 使用循环，从1开始，最大的Map集合的长度。根据序号获取对应的value。
        for(int i = 1; i <= map.size(); i++) {
            String content = map.get(i);
            //8. 把这些内容使用.分隔写入到新的文件中
            bw.write(i + "." + content);
            bw.newLine();
            bw.flush();
        }

        //释放资源
        bw.close();
    }
}
