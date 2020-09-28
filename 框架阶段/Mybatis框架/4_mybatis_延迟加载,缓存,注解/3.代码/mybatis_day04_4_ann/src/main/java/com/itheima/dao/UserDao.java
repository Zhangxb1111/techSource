package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    /**
     * 查询全部
     * @return
     */
    @Select("select u.*, _id id from user u")
    public List<User> findAll();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select u.*, _id id from user u where _id = #{id}")
    public User findById(Integer id);

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user values(null, #{username},#{address},#{birthday},#{sex})")
    public void save(User user);

    /**
     * 根据id删除
     * @param id
     */
    @Delete("delete from user where _id = #{a}")
    public void delById(Integer id);

    /**
     * 更新
     * @param user
     */
    @Update("update user set username=#{username},address=#{address}, birthday =#{birthday},sex = #{sex} where _id = #{id}")
    public void update(User user);
}
