package cn.itcast.demo01_exception;
/*
    如果想要在catch中查看捕获到的异常对应的异常信息，可以使用以下Throwable中的三个方法。

    （了解）String toString​()： 返回异常的详细描述。
    String getMessage​()： 返回异常的简短描述
    void printStackTrace​()：将异常信息打印到控制台。（最详细）
 */
public class Demo11ThrowableMethod {
    public static void main(String[] args) {
        try {
            int[] arr = new int[2];
            System.out.println(arr[10]);
        } catch (Exception e) {
            //调用toString()方法
            //System.out.println(e.toString()); //java.lang.ArrayIndexOutOfBoundsException: 10

            //String getMessage​()： 返回异常的详细描述
            //System.out.println(e.getMessage()); //10

            e.printStackTrace();
        }
    }
}
