package cn.itcast.demo06_对象引用成员方法;

public class Demo02MethodRef {
    public static void main(String[] args) {
        //method(s -> System.out.println("使用Lambda表达式手忙脚乱的处理" + s));

        Assistant a = new Assistant();
        //method(s -> a.doFile(s));

        method(a::doFile);
    }

    public static void method(Helper helper) {
        helper.help("机密文件.txt");
    }
}
