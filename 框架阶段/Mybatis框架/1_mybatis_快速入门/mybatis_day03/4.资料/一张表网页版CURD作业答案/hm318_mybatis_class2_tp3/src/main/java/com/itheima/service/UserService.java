package com.itheima.service;

import com.itheima.entity.UserInfo;

import java.util.List;

/**
 * 业务层接口
 */
public interface UserService {

    // 操作类型

    public static final int OPERATE_INSERT = 1; // 添加
    public static final int OPERATE_UPDATE = 2; // 更新
    public static final int OPERATE_DELETE = 3; // 删除

    /**
     * 增删改目标对象
     * @param userInfo
     * @param operateType
     * @return
     */
    public int operateUser(UserInfo userInfo,Integer operateType);

    /**
     * 按ID查询
     * @param id
     * @return
     */
    public UserInfo findUserByID(Integer id);

    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<UserInfo> findUserByPage(Integer pageIndex,Integer pageSize);

    /**
     * 查询数据总条数
     * @return
     */
    public int findUserByPageCount();




}
