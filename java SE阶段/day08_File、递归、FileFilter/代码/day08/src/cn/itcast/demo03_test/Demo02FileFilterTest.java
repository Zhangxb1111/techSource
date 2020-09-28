package cn.itcast.demo03_test;

import java.io.File;

/*
    如果希望调用listFiles方法的时候可以过滤掉自己不想要的内容，那么可以使用过滤器。

    在listFiles方法中，可以传递一个过滤器

    File[] listFiles​(MyFileFilter filter)：参数传递一个过滤器

    FileFilter是一个接口，表示的就是过滤器
    因为是一个接口，所以需要使用对应的实现类，这个实现类需要由我们自己创建，并且我们需要在实现类中定义过滤器的规则。


    过滤器中的方法
        boolean accept​(File pathname)： 返回值如果是false表示该File对象过滤掉。如果返回值是true表示该File对象留下。

    使用步骤：
        １.　定义一个类，实现FileFilter接口，这个类就变成了过滤器类。
        ２.　重写FileFilter中的accept方法，在里面定义过滤的规则。
        3.  在测试类中创建File对象，并且调用File对象的listFile方法，传递一个过滤器对象。
        4.  得到过滤后的结果。


 */
public class Demo02FileFilterTest {
    public static void main(String[] args) {
        //创建File对象
        File file = new File("d:\\iotest");

        //调用listFiles方法，并传递过滤器
        File[] files = file.listFiles(new MyFileFilter());

        //遍历
        for(File thisFile : files) {
            System.out.println(thisFile);
        }
    }
}
