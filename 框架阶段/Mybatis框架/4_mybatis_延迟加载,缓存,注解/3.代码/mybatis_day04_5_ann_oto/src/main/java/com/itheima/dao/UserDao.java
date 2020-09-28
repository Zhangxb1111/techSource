package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    /**
     * 查询全部
     * @return
     */
    @Select("select * from user")
    // @Results :相当于xml中resultMap，注解中配置结果映射
            //参数要求@Result的集合
            // result：属性
            /*
                    id: true（为主键），false(默认值，非主键 )
                    column:列名
                    property：属性名
             */
    @Results({
          @Result(id=true,column = "_id",property = "id"),
          @Result(column = "username",property = "username"),
          @Result(column = "birthday",property = "birthday")
    })
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
