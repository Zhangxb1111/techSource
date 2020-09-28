package cn.itcast.demo01_exception;
/*
    多个catch的异常处理方式

    try {
        要检测的代码
    } catch(要捕获的异常 变量名) {
        如果出现该异常对应的解决方案
    } catch(要捕获的异常 变量名) {
        如果出现该异常对应的解决方案
    } catch(要捕获的异常 变量名) {
        如果出现该异常对应的解决方案
    }


    执行流程：
        如果try中的代码出现了问题，那么哪一个catch先捕获到，那么就执行哪个catch中的代码。
        如果try中的代码没有任何问题，那么所有的catch都不执行。

    注意事项：
        如果使用多个catch捕获异常，那么父类异常不能放在子类异常的前面。
        因为子类异常能捕获到的，父类异常一定也可以捕获到，如果把父类异常放前面。
        父类异常会捕获到所有的导致子类异常没有东西可以捕获。
 */
public class Demo09TryCatchCatch {
    public static void main(String[] args) {
        try {
            Object obj = null;
            obj.toString();
            System.out.println("1. try...end");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("2. ArrayIndexOutOfBoundsException");
        } catch (NullPointerException e) {
            System.out.println("3. NullPointerException");
        } catch (Exception e) {
            System.out.println("4. Exception");
        }
    }
}
