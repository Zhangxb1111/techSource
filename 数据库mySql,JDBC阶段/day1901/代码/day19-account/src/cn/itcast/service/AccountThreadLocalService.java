package cn.itcast.service;

import cn.itcast.dao.AccountDao;
import cn.itcast.dao.AccountThreadLocalDao;
import cn.itcast.utils.ConnectionManager;
import cn.itcast.utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;

/*
    转账案例的Service层。
    Service层用来处理业务上的数据。

    Service被表现层调用， 里面会调用Dao层
 */
public class AccountThreadLocalService {
    /*
        转账方法
        参数inName：入账人姓名
        参数outName： 出账人姓名
        参数money：转账金额

        步骤：
            1. 开启事务
            2. 执行入账和出账这两条sql
            3. 如果没有问题，那么就提交。如果有问题，就回滚。
     */
    // inName rose, outName jack, money=100
    public void doAccount(String inName, String outName, int money) {
        try {
            //开启事务
            ConnectionManager.startTransaction();
            //通过Dao层执行入账和出账这两条sql
            AccountThreadLocalDao dao = new AccountThreadLocalDao();
            //执行加钱操作
            dao.inMoney(inName, money);
            //模拟停电
            //System.out.println(10 / 0);
            //执行减钱操作
            dao.OutMoney(outName, money);

            //提交事务
            ConnectionManager.commitTransaction();
        } catch (Exception e) {
            //如果上面代码出现了问题，那么我们就回滚事物
            try {
                ConnectionManager.rollbackTransaction();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            //如果转账过程出现了问题，并且catch捕获到了，就在这里面回滚，并且手动抛出一个异常
            throw new RuntimeException(e.getMessage());
        }

    }
}
