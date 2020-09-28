package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.utils.TxManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao accountDao;

    @Autowired
    TxManager txManager;


    /**
     * 转账
     * @param fromUser  从哪个用户转
     * @param toUser  转向哪个用户
     * @param money  转多少钱
     */
    public void transfer(String fromUser ,String  toUser, Double money){
        //开启事务
        txManager.openTransaction();
        try {
            //转账设计到的两个账户获取到
            Account fromAccount = accountDao.findByUsername(fromUser);
            Account toAccount = accountDao.findByUsername(toUser);
            //转出的过程
            fromAccount.setMoney(fromAccount.getMoney() - money);
            //持久化到数据库中
            accountDao.update(fromAccount); //是一个事务
            System.out.println(10/0);
//        转入
            toAccount.setMoney(toAccount.getMoney() + money);
            //持久化到数据库中
            accountDao.update(toAccount); //是一个事务
            // 提交事务
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 如果出现异常，回滚
            txManager.rollback();
        } finally {
            // 事务完成后，释放资源
            txManager.release();
        }

    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findByUsername(String username) {
        return accountDao.findByUsername(username);
    }

    public List<Account> findByPage(Integer pageNum, Integer pageSize) {
        return null;
    }

    public Account findById(Integer id) {
        return null;
    }

    public void save(Account account) {

    }

    public void update(Account account) {
        txManager.openTransaction();
        try {
            accountDao.update(account);
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManager.rollback();
        }finally {
            txManager.release();
        }
    }

    public void del(Integer id) {

    }

    public int getTotalCount() {
        return 0;
    }
}
