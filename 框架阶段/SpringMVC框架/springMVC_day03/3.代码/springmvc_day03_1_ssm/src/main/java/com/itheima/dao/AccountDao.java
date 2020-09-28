package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
//@Repository
//@MapperScan
public interface AccountDao {

    /**
     * 查询全部
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from account where id = #{id}")
    public Account findById(Integer id);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Select("select * from account where username = #{username}")
    public Account findByUsername(String username);

    /**
     * 保存账户
     * @param account
     */
    @Insert("insert into account values(null ,#{username} ,#{money})")
    public void save(Account account);

    /**
     * 更新账户
     * @param account
     */
    @Update("update account set money = #{money},username = #{username} where id = #{id}")
    public void update(Account account);

    /**
     * 删除账户
      * @param id
     */
    @Delete("delete from account where id = #{id}")
    public void del(Integer id);


}
