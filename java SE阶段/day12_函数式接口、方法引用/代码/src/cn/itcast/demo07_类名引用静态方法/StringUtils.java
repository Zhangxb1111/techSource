package cn.itcast.demo07_类名引用静态方法;

public class StringUtils {
    public static boolean isBlank(String s) {
        //验证，如果s是空字符串，就直接返回true
        return s == null || s.trim().equals("");
    }
}
