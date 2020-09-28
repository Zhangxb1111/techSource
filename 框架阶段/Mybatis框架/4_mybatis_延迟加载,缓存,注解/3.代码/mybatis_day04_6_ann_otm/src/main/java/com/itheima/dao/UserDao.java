package com.itheima.dao;

import com.itheima.domain.User;
import com.itheima.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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


               如果id使用了两次，那么必须都指定column ="id"

             */
    @Results({
          @Result(id=true,column = "id",property = "id"),
          @Result(column = "id",property = "accountList", javaType = List.class,
            many = @Many(select = "com.itheima.dao.AccountDao.findByUserId",fetchType = FetchType.LAZY)
            )
    })
    public List<User> findAll();


    /**
     * @SelectProvider() :sql语句的支持
     * @param user
     * @return
     */
    @SelectProvider(type = UserProvider.class ,method = "findByQuery")
    public List<User> findByQuery(User user);

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
