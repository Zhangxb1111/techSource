package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类型转换器:将字符类型转换为日期类型
 * String：接收到的类型
 * Date; 要转换的类型
 */
public class StringToDateConverter implements Converter<String ,Date> {
    @Override
    public Date convert(String source) {
        //简单的日期类型转换器：日期转成字符，也可以把字符串转成日期
        SimpleDateFormat dateFormat = null;
        Date date = null;
        try {
            dateFormat =new SimpleDateFormat("yyyy-MM-dd");
           date = dateFormat.parse(source);
        } catch (ParseException e) {
            throw  new RuntimeException("类型转换失败！！！") ;
        }
        return date;
    }
}
