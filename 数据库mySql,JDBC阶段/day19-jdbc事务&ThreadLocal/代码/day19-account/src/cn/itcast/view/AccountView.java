package cn.itcast.view;

import cn.itcast.service.AccountService;
import cn.itcast.service.AccountThreadLocalService;

/*
    表现层，这一层用来给用户看，用户也可以在这一层里面录入一些信息

    会调用Service层。


    在表现层中，我键盘录入入账人姓名，出账人姓名，转账金额，并调用Service层进行转账操作。
 */
public class AccountView {
    public static void main(String[] args) {
        //出账人姓名
        String outName = "jack";
        //入账人姓名
        String inName = "rose";
        //转账金额
        int price = 100;

        //调用Service层的方法进行转账
        //AccountService service = new AccountService();
        AccountThreadLocalService service = new AccountThreadLocalService();
        try {
            service.doAccount(inName, outName, price);
            System.out.println("转账成功");
        } catch (Exception e) {
            System.out.println("转账失败");
            System.out.println(e.getMessage());
        }

    }
}
