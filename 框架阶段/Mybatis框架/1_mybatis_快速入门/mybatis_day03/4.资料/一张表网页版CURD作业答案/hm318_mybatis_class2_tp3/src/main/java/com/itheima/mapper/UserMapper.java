package com.itheima.mapper;

import com.itheima.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * 用户的数据层接口
 */
public interface UserMapper {

    /**
     * 添加
     * @param user
     * @return
     * @throws RuntimeException
     */
    public int insertUser(UserInfo user)throws RuntimeException;

    /**
     * 更新
     * @param user
     * @return
     * @throws RuntimeException
     */
    public int updateUser(UserInfo user)throws RuntimeException;

    /**
     * 删除
     * @param user
     * @return
     * @throws RuntimeException
     */
    public int deleteUser(UserInfo user)throws RuntimeException;

    /**
     * 根据ID查询
     * @param id
     * @return
     * @throws RuntimeException
     */
    public UserInfo findUserByID(Integer id)throws RuntimeException;

    /**
     * 分页查询
     * @param map
     * @return
     * @throws RuntimeException
     */
    public List<UserInfo> findUsersByPage(Map<String,Integer> map)throws RuntimeException;


    /**
     * 获取数据总条数
     * @return
     * @throws RuntimeException
     */
    public int findUsersByPageCount()throws RuntimeException;

}
