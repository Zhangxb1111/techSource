package com.itheima.mapper;

import com.itheima.domain.QueryVO;
import com.itheima.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 查全部
     * @return
     */
    public List<User> findAll();

    /**
     * 根据queryVo查询
     * @param queryVO
     * @return
     */
    public List<User> findByPage(QueryVO queryVO);

    /**
     * 根据Map查询
     * @param map
     * @return
     */
    public List<User> findByMap(Map<String ,Object> map);

    /**
     * 多个查询条件
     * @return
     */
    public List<User> findByManyQueryVo(String username ,Integer pageSize,Integer startIndex);

    /**
     * 根据id查询
     * @return
     */
    public User findById(Integer id);
}
