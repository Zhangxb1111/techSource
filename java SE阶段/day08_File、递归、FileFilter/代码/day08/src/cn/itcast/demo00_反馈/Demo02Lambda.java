package cn.itcast.demo00_反馈;
/*
    () -> {}

    标准格式：
        (参数类型 参数名) -> {
            方法体;
            return 返回值;
        }


    Lambda表达式用的时候一定要有接口当做参数。（也可以使用接口类型接收这个Lambda）
    这个接口中有且仅有一个需要被重写的方法。
 */
public class Demo02Lambda {
    public static void invokeMethod(MyInterface myInterface){
        myInterface.method(10);
    }

    public static void main(String[] args) {
        /*
        invokeMethod(new MyInterface() {
            @Override
            public void method(int a) {
                System.out.println(a);
            }
        });
        */

        invokeMethod((int a) -> {
            try {
                System.out.println(a);
            } catch (Exception e) {

            }

        });

        //invokeMethod(a -> System.out.println(a));
    }
}
