package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有的账户
     * @return
     *
     * result属性：
     *      column：列名
     *      property:属性名
     *      javaType: 在java中类型
     * @One: 对应一个对象
     *  属性：select = ""  value：mapperId
     */
    @Select("select * from account")
    @Results({
            @Result(column = "uid",property = "user",javaType = User.class ,
                    one = @One(select = "com.itheima.dao.UserDao.findById",fetchType = FetchType.LAZY))
    })
    public List<Account> findAll();
}
