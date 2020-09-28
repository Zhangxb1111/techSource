package cn.itcast.demo01_exception;

import java.io.EOFException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Zi extends Fu{

    @Override
    public void method() throws EOFException {

    }

    @Override
    public void function() {
        //对指定的日期进行解析
        String str = "1999-07-10";
        //把这个字符串解析成Date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //如果调用了一个使用throws异常声明的方法，那么作为调用者必须处理这个异常。
            //要么往外抛，要么自己使用try...catch解决掉这个问题
            //因为父类方法没有抛，所以在这里只能try...catch处理
            sdf.parse(str);
        } catch (Exception e) {

        }


    }
}
