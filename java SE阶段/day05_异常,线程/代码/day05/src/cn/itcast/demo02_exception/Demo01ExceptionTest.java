package cn.itcast.demo02_exception;
/*
    模拟注册的练习，定义方法，用来注册，如果这个注册的用户名已经存在，抛出异常。
 */
public class Demo01ExceptionTest {
    //定义数组，当做数据库，用来保存已经存在的用户名
    private static String[] users = {"jack", "rose", "tony"};

    public static void main(String[] args) {
        try {
            //进行注册
            regist("tony");
            System.out.println("注册成功");
        } catch (RegistException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("出现了其他问题");
            e.printStackTrace();
        }
    }

    /*
        定义一个方法，用来注册
        参数是一个字符串，表示要注册的用户名
        如果此用户名已经存在，那么就以抛出异常的方式提示注册失败。
     */
    public static void regist(String username) {
        //遍历存放所有用户名的数组，和要注册用户名进行比较，如果相同，表示已经存在，那么就直接抛出异常
        for(String thisUser : users) {
            //进行比较，如果和要注册的相同，就抛出异常
            if(thisUser.equals(username)) {
                //throw new RuntimeException("用户名" + username + "已经存在");
                throw new RegistException("用户名" + username + "已经存在");
            }
        }
    }
}
