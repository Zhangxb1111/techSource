package cn.itcast.demo07_类名引用静态方法;

public class Demo02MethodRef {
    public static void main(String[] args) {
        //Lambda表达式中的检查规则，如果这个字符串是一个空字符串，那么就返回true
        //空字符串指的是这个字符串是 null或者这个字符串是一个空白的字符串
        //method("    ",  s -> s == null || s.trim().equals(""));

        //method("    ", s -> StringUtils.isBlank(s));

        method("   ", StringUtils::isBlank);
    }

    public static void method(String str, StringChecker checker) {
        boolean flag = checker.checkString(str);
        System.out.println("flag:" + flag);
    }
}
